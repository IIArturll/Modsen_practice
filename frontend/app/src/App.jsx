import { CssBaseline, Container } from '@mui/material';
import SignUp from './components/SignUp';
import SignIn from './components/SignIn';
import './App.css';

function App() {
  return (
    <div>
      <CssBaseline />
      <Container component="main" maxWidth="xs">
        <SignUp />
        <SignIn />
      </Container>
    </div>
  );
}

export default App;