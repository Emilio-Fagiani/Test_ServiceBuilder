create table ESAME_Esame (
	esameId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	nomeEsame VARCHAR(75) null,
	dataEsame DATE null,
	nomeInsegnante VARCHAR(75) null
);