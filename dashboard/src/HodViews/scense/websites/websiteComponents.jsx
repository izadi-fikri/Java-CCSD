import { Box, Link, useTheme } from "@mui/material";

import * as React from 'react';
import { tokens } from "../../../base/theme";
import Header from "../../../components/Header";
import ThreeGridBoxImage from "../../../components/3GridBoxImage";


const WebsiteComponentsAdmin = () =>{
      //const imageSrc = require("../../../assets/images/website_image.jpg").default;  
      const theme = useTheme();
      const colors = tokens(theme.palette.mode);
    return (

        <Box m="20px">
            <Box display="flex" justifyContent="space-between" alignItems="center">
                <Header title="Webpage COMPONENTS" subtitle = "Chose the Part You Want to Change" />
            </Box>
            <Box
                display="grid"
                gridTemplateColumns="repeat(12, 1fr)"
                gridAutoRows="140px"
                gap="20px"
                        >
            <Box gridColumn="span 4" backgroundColor = {colors.primary[400]} display="flex" alignItems="center" justifyContent="center">
                <Link href="/website-image-admin"><ThreeGridBoxImage 
                    image={require("../../../assets/images/website_image.jpg")}
                    title="Styles"
                    subtitle="Change The Current Style To Be Promoted"
                /></Link>
            </Box>
            <Box gridColumn="span 4" backgroundColor = {colors.primary[400]} display="flex" alignItems="center" justifyContent="center">
                <Link href="/website-text-admin"><ThreeGridBoxImage 
                    image={require("../../../assets/images/website_text.jpg")}
                    title="Website Texts"
                    subtitle="Update Our About Page"
                /></Link>
            </Box>
            <Box gridColumn="span 4" backgroundColor = {colors.primary[400]} display="flex" alignItems="center" justifyContent="center">
                <Link href="/website-image-gallery"><ThreeGridBoxImage 
                    image={require("../../../assets/images/website_slides.jpg")}
                    title="Collections"
                    subtitle="Change The Current Collections To Be Promoted"
                /></Link>
            </Box>
            </Box>
        </Box>
    );
};

export default WebsiteComponentsAdmin;