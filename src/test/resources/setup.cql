CREATE TABLE IF NOT EXISTS user (id TimeUUID PRIMARY KEY, firstname text, lastname text);
CREATE INDEX fistnameindex ON user (firstname);
CREATE INDEX lastnameindex ON user (lastname);

CREATE TABLE IF NOT EXISTS todo (id TimeUUID PRIMARY KEY, title text, description text);
CREATE INDEX titleindex ON todo (title);
CREATE INDEX descriptionindex ON todo (description);