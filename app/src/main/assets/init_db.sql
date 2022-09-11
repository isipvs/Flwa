PRAGMA foreign_keys = on;
CREATE TABLE hld (
   id_hld    INTEGER NOT NULL
                     PRIMARY KEY AUTOINCREMENT,
   hld_day   INTEGER NOT NULL,
   hld_month INTEGER NOT NULL,
   hld_name  TEXT,
   hld_type  INTEGER,
   CONSTRAINT ch_month CHECK (hld_month BETWEEN 1 AND 12) 
);
CREATE TABLE [order] (
   id_order  INTEGER NOT NULL
                     PRIMARY KEY AUTOINCREMENT,
   id_prdct  INTEGER NOT NULL,
   dtcreated INTEGER NOT NULL
                     DEFAULT (DATETIME('now') ),
   dtTo      INTEGER NOT NULL,
   note      TEXT,
   status    INTEGER NOT NULL,
   CONSTRAINT fk_prdct_to_order FOREIGN KEY (
      id_prdct
   )
   REFERENCES prdct (id_prdct) ON DELETE NO ACTION
                               ON UPDATE NO ACTION,
   CONSTRAINT ch_status CHECK (status IN (1, 2, 3) ),
   CONSTRAINT ch_dtto CHECK (dtto >= dtcreated) 
);
CREATE TABLE prdct (
   id_prdct   INTEGER NOT NULL
                      PRIMARY KEY,
   name       TEXT    NOT NULL,
   short_name TEXT,
   note       TEXT    NOT NULL,
   price      NUMERIC NOT NULL,
   image_id   TEXT    NOT NULL
);