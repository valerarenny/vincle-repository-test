
CREATE SCHEMA IF NOT EXISTS items;
ALTER DEFAULT PRIVILEGES IN SCHEMA items GRANT ALL ON TABLES TO postgres;
ALTER DEFAULT PRIVILEGES IN SCHEMA items GRANT ALL PRIVILEGES ON FUNCTIONS TO postgres];

GRANT USAGE ON SCHEMA items TO postgres;