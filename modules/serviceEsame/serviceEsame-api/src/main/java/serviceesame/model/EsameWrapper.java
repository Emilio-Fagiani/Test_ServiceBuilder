/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package serviceesame.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Esame}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Esame
 * @generated
 */
public class EsameWrapper
	extends BaseModelWrapper<Esame> implements Esame, ModelWrapper<Esame> {

	public EsameWrapper(Esame esame) {
		super(esame);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esameId", getEsameId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("nomeEsame", getNomeEsame());
		attributes.put("dataEsame", getDataEsame());
		attributes.put("nomeInsegnante", getNomeInsegnante());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esameId = (Long)attributes.get("esameId");

		if (esameId != null) {
			setEsameId(esameId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String nomeEsame = (String)attributes.get("nomeEsame");

		if (nomeEsame != null) {
			setNomeEsame(nomeEsame);
		}

		Date dataEsame = (Date)attributes.get("dataEsame");

		if (dataEsame != null) {
			setDataEsame(dataEsame);
		}

		String nomeInsegnante = (String)attributes.get("nomeInsegnante");

		if (nomeInsegnante != null) {
			setNomeInsegnante(nomeInsegnante);
		}
	}

	@Override
	public Esame cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this esame.
	 *
	 * @return the company ID of this esame
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this esame.
	 *
	 * @return the create date of this esame
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data esame of this esame.
	 *
	 * @return the data esame of this esame
	 */
	@Override
	public Date getDataEsame() {
		return model.getDataEsame();
	}

	/**
	 * Returns the esame ID of this esame.
	 *
	 * @return the esame ID of this esame
	 */
	@Override
	public long getEsameId() {
		return model.getEsameId();
	}

	/**
	 * Returns the group ID of this esame.
	 *
	 * @return the group ID of this esame
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this esame.
	 *
	 * @return the modified date of this esame
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the nome esame of this esame.
	 *
	 * @return the nome esame of this esame
	 */
	@Override
	public String getNomeEsame() {
		return model.getNomeEsame();
	}

	/**
	 * Returns the nome insegnante of this esame.
	 *
	 * @return the nome insegnante of this esame
	 */
	@Override
	public String getNomeInsegnante() {
		return model.getNomeInsegnante();
	}

	/**
	 * Returns the primary key of this esame.
	 *
	 * @return the primary key of this esame
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this esame.
	 *
	 * @return the user ID of this esame
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this esame.
	 *
	 * @return the user name of this esame
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this esame.
	 *
	 * @return the user uuid of this esame
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this esame.
	 *
	 * @param companyId the company ID of this esame
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this esame.
	 *
	 * @param createDate the create date of this esame
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data esame of this esame.
	 *
	 * @param dataEsame the data esame of this esame
	 */
	@Override
	public void setDataEsame(Date dataEsame) {
		model.setDataEsame(dataEsame);
	}

	/**
	 * Sets the esame ID of this esame.
	 *
	 * @param esameId the esame ID of this esame
	 */
	@Override
	public void setEsameId(long esameId) {
		model.setEsameId(esameId);
	}

	/**
	 * Sets the group ID of this esame.
	 *
	 * @param groupId the group ID of this esame
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this esame.
	 *
	 * @param modifiedDate the modified date of this esame
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the nome esame of this esame.
	 *
	 * @param nomeEsame the nome esame of this esame
	 */
	@Override
	public void setNomeEsame(String nomeEsame) {
		model.setNomeEsame(nomeEsame);
	}

	/**
	 * Sets the nome insegnante of this esame.
	 *
	 * @param nomeInsegnante the nome insegnante of this esame
	 */
	@Override
	public void setNomeInsegnante(String nomeInsegnante) {
		model.setNomeInsegnante(nomeInsegnante);
	}

	/**
	 * Sets the primary key of this esame.
	 *
	 * @param primaryKey the primary key of this esame
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this esame.
	 *
	 * @param userId the user ID of this esame
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this esame.
	 *
	 * @param userName the user name of this esame
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this esame.
	 *
	 * @param userUuid the user uuid of this esame
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected EsameWrapper wrap(Esame esame) {
		return new EsameWrapper(esame);
	}

}