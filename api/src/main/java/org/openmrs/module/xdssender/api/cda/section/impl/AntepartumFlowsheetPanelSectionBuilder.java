package org.openmrs.module.xdssender.api.cda.section.impl;

import org.marc.everest.datatypes.BL;
import org.marc.everest.datatypes.II;
import org.marc.everest.datatypes.generic.CD;
import org.marc.everest.datatypes.generic.CE;
import org.marc.everest.datatypes.generic.LIST;
import org.marc.everest.rmim.uv.cdar2.pocd_mt000040uv.Entry;
import org.marc.everest.rmim.uv.cdar2.pocd_mt000040uv.Section;
import org.marc.everest.rmim.uv.cdar2.vocabulary.x_ActRelationshipEntry;
import org.openmrs.ConceptNumeric;
import org.openmrs.Obs;
import org.openmrs.module.shr.cdahandler.CdaHandlerConstants;
import org.openmrs.module.xdssender.api.cda.entry.impl.AntepartumFlowsheetBatteryEntryBuilder;
import org.openmrs.module.xdssender.api.cda.entry.impl.SimpleObservationEntryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Flowsheet panel builder
 * 
 * @author JustinFyfe
 */
@Component("xdssender.AntepartumFlowsheetPanelSectionBuilder")
public class AntepartumFlowsheetPanelSectionBuilder extends SectionBuilderImpl {
	
	@Autowired
	private SimpleObservationEntryBuilder obsBuilder;
	
	@Autowired
	private AntepartumFlowsheetBatteryEntryBuilder batteryBuilder;
	
	/**
	 * Create flowsheet panel section
	 */
	@Override
	public Section generate(Entry... entries) {
		Section retVal = super.generate(entries);
		retVal.setTemplateId(LIST.createLIST(new II(
		        CdaHandlerConstants.SCT_TEMPLATE_ANTEPARTUM_TEMPLATE_VISIT_SUMMARY_FLOWSHEET)));
		retVal.setTitle("Antepartum Visist Summary Flowsheet Panel");
		retVal.setCode(new CE<String>("11369-6", CdaHandlerConstants.CODE_SYSTEM_LOINC,
		        CdaHandlerConstants.CODE_SYSTEM_NAME_LOINC, null, "PREGNANCY SUMMARY", null));
		return retVal;
	}
	
	/**
	 * Generate flowsheet panel section with the specified data
	 */
	public Section generate(Obs prepregnancyWeightObs, Obs gestgationalAgeObs, Obs fundalHeightObs, Obs presentationObs,
	        Obs systolicBpObs, Obs diastolicBpObs, Obs weightObs) {
		if (prepregnancyWeightObs != null && !(prepregnancyWeightObs.getConcept() instanceof ConceptNumeric))
			throw new IllegalArgumentException("prepregnancyWeightObs must be a numeric concept");
		
		Entry flowsheetBattery = new Entry(x_ActRelationshipEntry.HasComponent, BL.TRUE, batteryBuilder.generate(
		    gestgationalAgeObs, fundalHeightObs, presentationObs, systolicBpObs, diastolicBpObs, weightObs)), prepregnancyWeight = null;
		if (prepregnancyWeightObs != null) {
			prepregnancyWeight = new Entry(x_ActRelationshipEntry.HasComponent, BL.TRUE, obsBuilder.generate(new CD<String>(
			        "8348-5", CdaHandlerConstants.CODE_SYSTEM_LOINC, CdaHandlerConstants.CODE_SYSTEM_NAME_LOINC, null,
			        "Prepregnancy Weight", null), prepregnancyWeightObs));
			return this.generate(prepregnancyWeight, flowsheetBattery);
		} else
			return this.generate(flowsheetBattery);
		
	}
}
