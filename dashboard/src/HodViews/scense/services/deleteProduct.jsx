import { Box, Typography, useTheme, Button, Grid } from "@mui/material";
import { DataGrid } from "@mui/x-data-grid";
import { Link } from "react-router-dom";
import { tokens } from "../../../base/theme";
import AdminPanelSettingsOutlinedIcon from "@mui/icons-material/AdminPanelSettingsOutlined";
import LockOpenOutlinedIcon from "@mui/icons-material/LockOpenOutlined";
import SecurityOutlinedIcon from "@mui/icons-material/SecurityOutlined";
import PersonAddAltOutlinedIcon from '@mui/icons-material/PersonAddAltOutlined';
import Header from "../../../components/Header";
import React, { useState, useEffect } from "react";
import DeleteOutlinedIcon from '@mui/icons-material/DeleteOutlined';
import axios from 'axios';

const ProductListAdmin = () => {
    const API_BASE_URL = 'http://localhost:8082';
    const token = localStorage.getItem('jwtToken');
    const username = localStorage.getItem('userName');
    const [products, setProducts] = useState([]);

    axios.defaults.withCredentials = true;

    useEffect(() => {
        // Fetch all products from the API
        fetch(`${API_BASE_URL}/api/products`, {
            headers: {
                'Content-Type': 'application/json',
                Authorization: `Bearer ${token}`,
            }
        })
            .then(response => response.json())
            .then(data => {
                setProducts(data);
            })
            .catch(error => console.error('Error fetching products:', error));
    }, []);


    const handleDelete = (id) => {
        // Make the DELETE request to the backend API
        axios.delete(`${API_BASE_URL}/api/products/${id}`, {
            headers: {
                'Authorization': `Bearer ${token}`, // Include JWT token if needed for authorization
            },
        })
            .then((response) => {
                // Handle success response
                console.log("Product successfully deleted:", response.data);
                // Update the state to remove the deleted user from the teamDetails
                setProducts((prevProducts) => prevProducts.filter(image => id !== id));
            })
            .catch((error) => {
                // Handle error
                console.error("Error deleting the product:", error);
            });
    };


    const theme = useTheme();
    const colors = tokens(theme.palette.mode);

    const columns = [
        { field: "id", headerName: "ID" },
        { field: "title", headerName: "TITLE", flex: 1, cellClassName: "name-column--cell" },
        { field: "tag", headerName: "PRICE", flex: 1 },
        { field: "postShortDescription", headerName: "DESCRIPTION", flex: 1 },
        { field: "postSlug", headerName: "POST SLUG", flex: 1 },
        {
            field: "image",
            headerName: "IMAGE",
            flex: 1,
            renderCell: (params) => {
                return params.value ? (
                    <img
                        src={params.value}
                        alt="Product"
                        style={{ width: 40, height: 40, objectFit: "cover", borderRadius: "4px", display: "block", margin: "8 auto" }}

                    />
                ) : (
                    "No Image"
                );
            },
        },


        {
            field: "delete",
            headerName: "Delete",
            flex: 1,
            headerAlign: 'center',
            align: 'center',
            renderCell: (params) => {
                return (
                    <Button
                        variant="outlined"
                        color="error"
                        onClick={() => handleDelete(params.id)}
                        startIcon={<DeleteOutlinedIcon />}
                        sx={{
                            width: '100%', // Makes the button expand to fill the cell
                            justifyContent: 'start', // Aligns the text and icon to the left
                            '&:hover': {
                                backgroundColor: '#ffdddd', // Light red background on hover
                            }
                        }}
                        aria-label={`Delete image ${params.row.title}`}
                    >
                        Delete
                    </Button>
                );
            },

        },
    ];

    // Map the teamDetails to match the DataGrid row structure
    const rows = productDetails.map((products) => {
        // Ensure `userId` is set as a unique id
        const id = products.id //|| `user-${Math.random()}`; // Fallback if userId is undefined
        //const name = user.firstName && user.lastName ? `${user.firstName} ${user.lastName}` : "Unknown Name"; // Handle undefined names

        return {
            id: id, // Ensure each row has a unique `id`
            title: products.title, // Concatenate first and last name, fallback to "Unknown Name"
            tag: products.tag || "N/A", // Fallback if phone number is missing
            postShortDescription: products.postShortDescription || "N/A", // Fallback if email is missing
            postSlug: products.postSlug || "N/A", // Fallback if role is missing
            imageStore:products.imageStore
                ?`data:image/jpeg;base64, ${products.image}`
                :null //data:image/jpeg;base64,${image.image} ⁠ || "N/A"
        };
    });

    return (
        <Box>
            <Header title="All Products" subtitle="Managing the Products" />
            <Box>
                <DataGrid
                    rows={rows} // Use the mapped rows here
                    columns={columns}
                    pageSize={12}
                />
            </Box>
        </Box>
    );
};





export default ProductListAdmin;