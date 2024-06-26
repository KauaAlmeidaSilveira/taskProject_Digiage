INSERT INTO tb_department (nome, descricao, status) VALUES
  ('Desenvolvimento de Software', 'Departamento responsável pelo desenvolvimento de software e aplicativos.', 'Ativo'),
  ('Analise e Gestão de Dados', 'Departamento responsável pela análise de dados, gerenciamento de bancos de dados e análise de negócios.', 'Ativo'),
  ('Engenharia de Software e Infraestrutura', 'Departamento responsável pela infraestrutura de TI, redes e engenharia de software.', 'Ativo'),
  ('Gestao de Projetos e Qualidade', 'Departamento responsável pela gestão de projetos, garantia de qualidade e conformidade.', 'Ativo'),
  ('Suporte Técnico e Atendimento ao Cliente', 'Departamento responsável por fornecer suporte técnico aos usuários e garantir a satisfação do cliente.', 'Ativo');


INSERT INTO tb_employee (NOME, EMAIL, TELEFONE, DATA_NASCIMENTO, CARGO, DEPARTMENT_ID) VALUES
  ('Kauã Almeida', 'kaua@example.com', '(11)12345-6789', '2004-11-20', 'Dev na digiage', 1),
  ('Maria Souza', 'maria.souza@example.com', '(11)22345-6789', '1988-02-20', 'Analista de Sistemas', 4),
  ('José Santos', 'jose.santos@example.com', '(11)32345-6789', '1995-09-10', 'Gerente de Projetos', 4),
  ('Ana Oliveira', 'ana.oliveira@example.com', '(11)42345-6789', '1980-07-05', 'Engenheiro de Software', 3),
  ('Paula Lima', 'paula.lima@example.com', '(11)52345-6789', '1992-03-18', 'Desenvolvedor Front-End', 1),
  ('Carlos Ferreira', 'carlos.ferreira@example.com', '(11)62345-6789', '1987-11-30', 'Desenvolvedor Back-End', 1),
  ('Amanda Silva', 'amanda.silva@example.com', '(11)72345-6789', '1984-06-25', 'Analista de Dados', 2),
  ('Rafael Pereira', 'rafael.pereira@example.com', '(11)82345-6789', '1991-12-15', 'Arquiteto de Software', 3),
  ('Fernanda Costa', 'fernanda.costa@example.com', '(11)92345-6789', '1983-04-08', 'Analista de Negócios', 4),
  ('Gustavo Martins', 'gustavo.martins@example.com', '(11)52345-6789', '1990-10-22', 'Scrum Master', 4),
  ('Luciana Oliveira', 'luciana.oliveira@example.com', '(11)52345-6789', '1986-08-14', 'Product Owner', 4),
  ('Roberto Santos', 'roberto.santos@example.com', '(11)52345-6789', '1993-05-07', 'Desenvolvedor Full Stack', 1),
  ('Carla Rodrigues', 'carla.rodrigues@example.com', '(11)52345-6789', '1989-01-29', 'Analista de Testes', 4),
  ('Márcio Silva', 'marcio.silva@example.com', '(11)52345-6789', '1982-09-03', 'Analista de Segurança', 4),
  ('Patrícia Sousa', 'patricia.sousa@example.com', '(11)52345-6789', '1985-11-12', 'Desenvolvedor Mobile', 1),
  ('Henrique Almeida', 'henrique.almeida@example.com', '(11)52345-6789', '1996-07-26', 'Designer UI/UX', 3),
  ('Tatiane Oliveira', 'tatiane.oliveira@example.com', '(11)52345-6789', '1981-02-17', 'Engenheiro de DevOps', 3),
  ('Roberta Costa', 'roberta.costa@example.com', '(11)52345-6789', '1994-06-09', 'Analista de Suporte', 5),
  ('Bruno Santos', 'bruno.santos@example.com', '(11)52345-6789', '1988-04-23', 'Administrador de Banco de Dados', 3),
  ('Daniela Lima', 'daniela.lima@example.com', '(11)52345-6789', '1984-10-16', 'Especialista em Cloud Computing', 3),
  ('Marcelo Oliveira', 'marcelo.oliveira@example.com', '(11)52345-6789', '1987-03-30', 'Analista de Redes', 3),
  ('Mariana Pereira', 'mariana.pereira@example.com', '(11)52345-6789', '1991-09-08', 'Desenvolvedor de Jogos', 1),
  ('Paulo Costa', 'paulo.costa@example.com', '(11)52345-6789', '1983-12-21', 'Analista de Machine Learning', 4),
  ('Camila Santos', 'camila.santos@example.com', '(11)52345-6789', '1986-02-03', 'Cientista de Dados', 2),
  ('Felipe Oliveira', 'felipe.oliveira@example.com', '(11)52345-6789', '1990-08-18', 'Analista de Business Intelligence', 2),
  ('Vanessa Costa', 'vanessa.costa@example.com', '(11)52345-6789', '1989-01-14', 'Engenheiro de IoT', 3),
  ('Alexandre Santos', 'alexandre.santos@example.com', '(11)52345-6789', '1982-07-27', 'Analista de Automação de Testes', 4),
  ('Juliana Oliveira', 'juliana.oliveira@example.com', '(11)52345-6789', '1993-11-04', 'Analista de Qualidade', 4);
