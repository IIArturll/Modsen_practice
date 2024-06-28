import React, { useState } from "react";
import {
  Button,
  CssBaseline,
  TextField,
  Grid,
  Box,
  Typography,
  Container,
  FormControlLabel,
  Checkbox,
  Link,
  InputLabel,
  Select,
  MenuItem,
  FormControl,
} from "@mui/material";
import { createTheme, ThemeProvider } from "@mui/material/styles";
import { LocalizationProvider, DatePicker } from "@mui/x-date-pickers";
import { AdapterDateFns } from "@mui/x-date-pickers/AdapterDateFns";
import "../styles/FormElements.css";
const theme = createTheme();

function SignIn() {
  const [formData, setFormData] = useState({
    identifier: "",
    password: "",
  });

  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: type === "checkbox" ? checked : value,
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    console.log(formData);
  };

  return (
    <ThemeProvider theme={theme}>
      <Container
        component="main"
        maxWidth="xs"
        sx={{
          boxShadow: "2px 6px 30px rgba(0, 0, 0, 0.4)",
          borderRadius: "30px",
          padding: "40px",
          width: "840px",
        }}
      >
        <CssBaseline />
        <Box
          sx={{
            marginTop: "20",
            display: "flex",
            flexDirection: "column",
            alignItems: "center",
          }}
        >
          <Typography
            component="h1"
            variant="h4"
            sx={{
              fontFamily: "'Roboto', sans-serif",
              fontWeight: "bold",
            }}
          >
            SIGN IN
          </Typography>
          <Box
            component="form"
            noValidate
            onSubmit={handleSubmit}
            sx={{ mt: 3 }}
          >
            <Grid container spacing={2}>
              <Grid item xs={12}>
                <TextField
                  name="identifier"
                  required
                  fullWidth
                  id="firstName"
                  label="Login or email"
                  autoFocus
                  value={formData.identifier}
                  onChange={handleChange}
                  className="my-input"
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  name="password"
                  required
                  fullWidth
                  id="password"
                  label="Password"
                  type="password"
                  value={formData.password}
                  onChange={handleChange}
                  className="my-input"
                />
              </Grid>
              <Grid container justifyContent="flex-end">
                <Grid item>
                  <Link href="#" variant="body2">
                    Forgot password?
                  </Link>
                </Grid>
              </Grid>
            </Grid>
            <Button
              type="submit"
              fullWidth
              variant="contained"
              sx={{
                mt: 1,
                mb: 0,
                backgroundColor: "#FF9921",
                borderRadius: 20,
                "&:hover": {
                  backgroundColor: "#cc7a1a",
                },
              }}
            >
              sign in
            </Button>
            <Grid container justifyContent="flex-end">
              <Grid item>
                <Link href="#" variant="body2">
                  Don't have an account? Sign up
                </Link>
              </Grid>
            </Grid>
          </Box>
        </Box>
      </Container>
    </ThemeProvider>
  );
}

export default SignIn;
