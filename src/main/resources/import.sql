
INSERT INTO PRODUTO (ID, DESCRICAO, VALOR)  VALUES(10000, 'MOUSE', 56.87);
INSERT INTO PRODUTO (ID, DESCRICAO, VALOR) VALUES(20000, 'TECLADO', 119.99);
INSERT INTO PRODUTO (ID, DESCRICAO, VALOR) VALUES(30000, 'NOTEBOOK', 3942.76);

INSERT INTO VENDEDOR (ID, NOME) VALUES(10000, 'Fulano de tal');
INSERT INTO VENDEDOR (ID, NOME) VALUES(20000, 'Cicrano de tol');
INSERT INTO VENDEDOR (ID, NOME) VALUES(30000, 'Beutrano de til');
INSERT INTO VENDEDOR (ID, NOME) VALUES(40000, 'Teste dos santos');
INSERT INTO VENDEDOR (ID, NOME) VALUES(50000, 'Testando da silva');


INSERT INTO VENDA (ID, DATA_VENDA, VALOR_TOTAL, VENDEDOR) VALUES(10000, '2022-12-04', '3700.76', 30000);
INSERT INTO VENDA (ID, DATA_VENDA, VALOR_TOTAL, VENDEDOR) VALUES(20000, '2022-12-05', '119.99', 30000);
INSERT INTO VENDA (ID, DATA_VENDA, VALOR_TOTAL, VENDEDOR) VALUES(30000, '2022-12-06', '56.87', 30000);

INSERT INTO VENDA (ID, DATA_VENDA, VALOR_TOTAL, VENDEDOR) VALUES(40000, '2022-12-05', '56.87', 20000);
INSERT INTO VENDA (ID, DATA_VENDA, VALOR_TOTAL, VENDEDOR) VALUES(50000, '2022-12-07', '56.87', 50000);



INSERT INTO VENDA_PRODUTOS (VENDA_ID, PRODUTO_ID) VALUES(10000,30000);
INSERT INTO VENDA_PRODUTOS (VENDA_ID, PRODUTO_ID) VALUES(20000,20000);
INSERT INTO VENDA_PRODUTOS (VENDA_ID, PRODUTO_ID) VALUES(30000,10000);
INSERT INTO VENDA_PRODUTOS (VENDA_ID, PRODUTO_ID) VALUES(40000,10000);
INSERT INTO VENDA_PRODUTOS (VENDA_ID, PRODUTO_ID) VALUES(50000,10000);

