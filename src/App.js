import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'; // Alteração para Routes
import Home from './Home';
import Servico from './servico/Servico';

function App() {
  return (
    <Router>
      <div>
        <Routes> {/* Alteração para Routes */}
          <Route path="/" element={<Home />} /> {/* Alteração para element */}
          <Route path="/cadastrar-servico" element={<Servico />} /> {/* Alteração para element */}
          {/* Adicione outras rotas conforme necessário */}
        </Routes> {/* Alteração para Routes */}
      </div>
    </Router>
  );
}

export default App;
