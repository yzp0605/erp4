package com.sxt.bus.service;

import java.util.List;

import com.sxt.bus.domain.Ouport;
import com.sxt.bus.vo.OuportVo;
import com.sxt.sys.utils.DataGridView;

public interface OutportService {

	List<Ouport> queryAllOuport(OuportVo ouportVo);

	DataGridView loadOuport(OuportVo ouportVo);

	void addOuport(OuportVo ouportVo);

	Ouport queryOuportById(Integer id);

	void updateOuport(OuportVo ouportVo);

	void deleteOuport(OuportVo ouportVo);

}
