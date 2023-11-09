-- Insert countries
INSERT INTO country (name) VALUES
('United States'),
('United Kingdom'),
('France'),
('Canada');

-- Insert cities for the United States
INSERT INTO city (name, country_id) VALUES
('New York', 1),
('Los Angeles', 1),
('Chicago', 1);

-- Insert cities for the United Kingdom
INSERT INTO city (name, country_id) VALUES
('London', 2),
('Manchester', 2),
('Birmingham', 2);

-- Insert cities for France
INSERT INTO city (name, country_id) VALUES
('Paris', 3),
('Marseille', 3),
('Lyon', 3);

-- Insert cities for Canada
INSERT INTO city (name, country_id) VALUES
('Toronto', 4),
('Vancouver', 4),
('Montreal', 4);

-- Insert streets for New York
INSERT INTO street (id, created_at, name, city_id) VALUES
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Broadway', 1),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), '5th Avenue', 1),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Wall Street', 1),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Park Avenue', 1),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Madison Avenue', 1),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Lexington Avenue', 1),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Queens Boulevard', 1),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Central Park West', 1),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Times Square', 1),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Harlem Avenue', 1);

-- Insert streets for Los Angeles
INSERT INTO street (id, created_at, name, city_id) VALUES
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Sunset Boulevard', 2),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Hollywood Boulevard', 2),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Rodeo Drive', 2),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Venice Beach Boardwalk', 2),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Wilshire Boulevard', 2),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Melrose Avenue', 2),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Santa Monica Boulevard', 2),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'La Cienega Boulevard', 2),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Downtown LA', 2),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Pacific Coast Highway', 2);

-- Insert streets for Chicago
INSERT INTO street (id, created_at, name, city_id) VALUES
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Michigan Avenue', 3),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'State Street', 3),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'The Magnificent Mile', 3),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Wacker Drive', 3),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'LaSalle Street', 3),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Navy Pier', 3),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'River North', 3),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'The Loop', 3),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Hyde Park', 3),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Lincoln Park', 3);

-- Insert streets for London
INSERT INTO street (id, created_at, name, city_id) VALUES
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Oxford Street', 4),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Regent Street', 4),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Baker Street', 4),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Piccadilly Circus', 4),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Westminster Bridge Road', 4),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Kensington High Street', 4),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Notting Hill Gate', 4),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Buckingham Palace Road', 4),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'The Strand', 4),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Covent Garden', 4);

-- Insert streets for Manchester
INSERT INTO street (id, created_at, name, city_id) VALUES
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Deansgate', 5),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Market Street', 5),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Oxford Road', 5),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Albert Square', 5),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Piccadilly Gardens', 5),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Exchange Square', 5),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Ancoats', 5),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Castlefield', 5),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Salford Quays', 5),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'MediaCityUK', 5);

-- Insert streets for Birmingham
INSERT INTO street (id, created_at, name, city_id) VALUES
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Broad Street', 6),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Bull Ring', 6),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'New Street', 6),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Victoria Square', 6),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'High Street', 6),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Colmore Row', 6),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Digbeth', 6),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Jewellery Quarter', 6),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Edgbaston', 6),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Five Ways', 6);

-- Insert streets for Paris
INSERT INTO street (id, created_at, name, city_id) VALUES
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Champs-Élysées', 7),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Montmartre', 7),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Boulevard Saint-Germain', 7),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Avenue des Champs-Élysées', 7),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Rue de Rivoli', 7),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Rue du Faubourg Saint-Honoré', 7),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Place de la Concorde', 7),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Rue de la Roquette', 7),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Rue de Belleville', 7),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Rue de la Pompe', 7);

-- Insert streets for Marseille
INSERT INTO street (id, created_at, name, city_id) VALUES
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'La Canebière', 8),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Vieux-Port', 8),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Avenue du Prado', 8),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Rue de la République', 8),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Le Panier', 8),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Le Vieux-Port', 8),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'La Plaine', 8),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Belsunce', 8),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Endoume', 8),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Le Roucas-Blanc', 8);

-- Insert streets for Lyon
INSERT INTO street (id, created_at, name, city_id) VALUES
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Rue de la République', 9),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Place Bellecour', 9),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Vieux Lyon', 9),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Croix-Rousse', 9),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'La Part-Dieu', 9),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Les Terreaux', 9),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Guillotière', 9),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Gerland', 9),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Confluence', 9),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Saxe-Gambetta', 9);

-- Insert streets for Toronto
INSERT INTO street (id, created_at, name, city_id) VALUES
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Yonge Street', 10),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Queen Street West', 10),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Bloor Street', 10),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'King Street', 10),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Bay Street', 10),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Dundas Street', 10),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Spadina Avenue', 10),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'University Avenue', 10),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Avenue Road', 10),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Front Street', 10);

-- Insert streets for Vancouver
INSERT INTO street (id, created_at, name, city_id) VALUES
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Robson Street', 11),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Granville Street', 11),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Davie Street', 11),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Burrard Street', 11),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Denman Street', 11),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Commercial Drive', 11),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Kitsilano', 11),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Main Street', 11),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Hastings Street', 11),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Yaletown', 11);

-- Insert streets for Montreal
INSERT INTO street (id, created_at, name, city_id) VALUES
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Sainte-Catherine Street', 12),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Rue Saint-Denis', 12),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Boulevard Saint-Laurent', 12),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Old Montreal', 12),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Plateau-Mont-Royal', 12),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Vieux-Port de Montréal', 12),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Rue Sherbrooke', 12),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'The Village', 12),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Le Plateau', 12),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'Mile End', 12);
