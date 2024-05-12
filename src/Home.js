import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import './Home.css';

const Home = () => {
  const [showOptions, setShowOptions] = useState(false);
  const [showClientOptions, setShowClientOptions] = useState(false);

  return (
    <div className="page-container">
      <header className="header">
        <h1>Seja bem-vindo ao Integrado Sistemas</h1>
      </header>
      <main className="main-content">
        <div className="menu-container">
          <div
            className="menu-item"
            onMouseEnter={() => setShowOptions(true)}
            onMouseLeave={() => setShowOptions(false)}
          >
            <h2>Serviços</h2>
            {showOptions && (
              <div className="options">
                <Link to="/cadastrar-servico" className="btn-secondary">Cadastrar</Link>
                <Link to="/relatorios" className="btn-secondary">Relatórios</Link>
              </div>
            )}
          </div>
          <div
            className="menu-item"
            onMouseEnter={() => setShowClientOptions(true)}
            onMouseLeave={() => setShowClientOptions(false)}
          >
            <h2>Clientes</h2>
            {showClientOptions && (
              <div className="options">
                <Link to="/cadastrar-cliente" className="btn-secondary">Cadastrar</Link>
                <Link to="/relatorios-cliente" className="btn-secondary">Relatórios</Link>
              </div>
            )}
          </div>
        </div>
      </main>
      <footer className="footer">
        <p>&copy; 2024 Integrado sistemas. Todos os direitos reservados.</p>
      </footer>
    </div>
  );
};

export default Home;
