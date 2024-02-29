/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package serviceesame.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import serviceesame.model.Esame;

/**
 * The cache model class for representing Esame in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EsameCacheModel implements CacheModel<Esame>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EsameCacheModel)) {
			return false;
		}

		EsameCacheModel esameCacheModel = (EsameCacheModel)object;

		if (esameId == esameCacheModel.esameId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, esameId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{esameId=");
		sb.append(esameId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", nomeEsame=");
		sb.append(nomeEsame);
		sb.append(", dataEsame=");
		sb.append(dataEsame);
		sb.append(", nomeInsegnante=");
		sb.append(nomeInsegnante);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Esame toEntityModel() {
		EsameImpl esameImpl = new EsameImpl();

		esameImpl.setEsameId(esameId);
		esameImpl.setGroupId(groupId);
		esameImpl.setCompanyId(companyId);
		esameImpl.setUserId(userId);

		if (userName == null) {
			esameImpl.setUserName("");
		}
		else {
			esameImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esameImpl.setCreateDate(null);
		}
		else {
			esameImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esameImpl.setModifiedDate(null);
		}
		else {
			esameImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (nomeEsame == null) {
			esameImpl.setNomeEsame("");
		}
		else {
			esameImpl.setNomeEsame(nomeEsame);
		}

		if (dataEsame == Long.MIN_VALUE) {
			esameImpl.setDataEsame(null);
		}
		else {
			esameImpl.setDataEsame(new Date(dataEsame));
		}

		if (nomeInsegnante == null) {
			esameImpl.setNomeInsegnante("");
		}
		else {
			esameImpl.setNomeInsegnante(nomeInsegnante);
		}

		esameImpl.resetOriginalValues();

		return esameImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esameId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		nomeEsame = objectInput.readUTF();
		dataEsame = objectInput.readLong();
		nomeInsegnante = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(esameId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (nomeEsame == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nomeEsame);
		}

		objectOutput.writeLong(dataEsame);

		if (nomeInsegnante == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nomeInsegnante);
		}
	}

	public long esameId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String nomeEsame;
	public long dataEsame;
	public String nomeInsegnante;

}