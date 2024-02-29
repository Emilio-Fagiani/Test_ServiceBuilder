/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package serviceesame.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;ESAME_Esame&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Esame
 * @generated
 */
public class EsameTable extends BaseTable<EsameTable> {

	public static final EsameTable INSTANCE = new EsameTable();

	public final Column<EsameTable, Long> esameId = createColumn(
		"esameId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EsameTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EsameTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EsameTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EsameTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EsameTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EsameTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EsameTable, String> nomeEsame = createColumn(
		"nomeEsame", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EsameTable, Date> dataEsame = createColumn(
		"dataEsame", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EsameTable, String> nomeInsegnante = createColumn(
		"nomeInsegnante", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private EsameTable() {
		super("ESAME_Esame", EsameTable::new);
	}

}