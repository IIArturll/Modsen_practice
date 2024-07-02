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

function SignUp() {
  const [formData, setFormData] = useState({
    firstName: "",
    lastName: "",
    sex: "",
    dob: null,
    login: "",
    email: "",
    password: "",
    repeatPassword: "",
    marketing: false,
    privacyPolicy: false,
  });

  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: type === "checkbox" ? checked : value,
    }));
  };

  const handleDateChange = (date) => {
    setFormData((prev) => ({
      ...prev,
      dob: date,
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    console.log(formData);
  };

  return (
    <ThemeProvider theme={theme}>
      <LocalizationProvider dateAdapter={AdapterDateFns}>
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
              SIGN UP
            </Typography>
            <Box
              component="form"
              noValidate
              onSubmit={handleSubmit}
              sx={{ mt: 3 }}
            >
              <Grid container spacing={2}>
                <Grid item xs={12} sm={6}>
                  <TextField
                    name="firstName"
                    required
                    fullWidth
                    id="firstName"
                    label="First Name"
                    autoFocus
                    value={formData.firstName}
                    onChange={handleChange}
                    className="my-input"
                  />
                </Grid>
                <Grid item xs={12} sm={6}>
                  <TextField
                    name="lastName"
                    required
                    fullWidth
                    id="lastName"
                    label="Last Name"
                    value={formData.lastName}
                    onChange={handleChange}
                    className="my-input"
                  />
                </Grid>
                <Grid item xs={12} sm={6}>
                  <FormControl fullWidth required>
                    <InputLabel id="sex-label">Sex</InputLabel>
                    <Select
                      labelId="sex-label"
                      id="sex"
                      name="sex"
                      value={formData.sex}
                      label="Sex"
                      onChange={handleChange}
                      className="my-input"
                    >
                      <MenuItem value="Male">Male</MenuItem>
                      <MenuItem value="Female">Female</MenuItem>
                    </Select>
                  </FormControl>
                </Grid>
                <Grid item xs={12} sm={6}>
                  <DatePicker
                    label="Date of Birth *"
                    value={formData.dob}
                    onChange={handleDateChange}
                    renderInput={(params) => (
                      <TextField {...params} fullWidth required />
                    )}
                    required
                    className="my-input"
                  />
                </Grid>
                <Grid item xs={12}>
                  <TextField
                    name="login"
                    required
                    fullWidth
                    id="login"
                    label="Login"
                    value={formData.login}
                    onChange={handleChange}
                    className="my-input"
                  />
                </Grid>
                <Grid item xs={12}>
                  <TextField
                    name="email"
                    required
                    fullWidth
                    id="email"
                    label="Email"
                    value={formData.email}
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
                <Grid item xs={12}>
                  <TextField
                    name="repeatPassword"
                    required
                    fullWidth
                    id="repeatPassword"
                    label="Repeat Password"
                    type="password"
                    value={formData.repeatPassword}
                    onChange={handleChange}
                    className="my-input"
                  />
                </Grid>
                <Grid item xs={12}>
                  <FormControlLabel
                    control={
                      <Checkbox
                        name="marketing"
                        color="primary"
                        checked={formData.marketing}
                        onChange={handleChange}
                        className="my-checkbox-text"
                      />
                    }
                    label="I want to receive inspiration, marketing promotions and updates via email."
                  />
                </Grid>
                <Grid item xs={12}>
                  <FormControlLabel
                    control={
                      <Checkbox
                        name="privacyPolicy"
                        color="primary"
                        checked={formData.privacyPolicy}
                        onChange={handleChange}
                        required
                        className="my-checkbox-text"
                      />
                    }
                    label="I have read and claim privacy policy."
                  />
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
                sign up
              </Button>
              <Grid container justifyContent="flex-end">
                <Grid item>
                  <Link href="#" variant="body2">
                    Already have an account? Sign in
                  </Link>
                </Grid>
              </Grid>
            </Box>
          </Box>
        </Container>
      </LocalizationProvider>
    </ThemeProvider>
  );
}

export default SignUp;
