CREATE TABLE IF NOT EXISTS roles (
    role_id SERIAL PRIMARY KEY NOT NULL,
    title VARCHAR(32) NOT NULL UNIQUE
);

INSERT INTO roles (title) VALUES
        ('CLIENT'), ('EMPLOYEE'), ('ADMIN');

CREATE TABLE IF NOT EXISTS users (
    user_id BIGSERIAL PRIMARY KEY NOT NULL,
    username VARCHAR(128) NOT NULL,
    login VARCHAR(128) UNIQUE NOT NULL,
    password VARCHAR(128) NOT NULL,
    user_role INT NOT NULL,
    FOREIGN KEY (user_role) REFERENCES roles (role_id)
);

CREATE TABLE IF NOT EXISTS products (
    product_id BIGSERIAL PRIMARY KEY NOT NULL,
    title VARCHAR(255) NOT NULL,
    price DECIMAL NOT NULL
);

CREATE TABLE IF NOT EXISTS transactions (
    transaction_id BIGSERIAL PRIMARY KEY NOT NULL,
    user_owner BIGINT NOT NULL,
    FOREIGN KEY (user_owner) REFERENCES users (user_id)
);

CREATE TABLE IF NOT EXISTS transactions_products (
    transaction_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    UNIQUE (transaction_id, product_id),
    FOREIGN KEY (transaction_id) REFERENCES transactions (transaction_id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products (product_id)
);