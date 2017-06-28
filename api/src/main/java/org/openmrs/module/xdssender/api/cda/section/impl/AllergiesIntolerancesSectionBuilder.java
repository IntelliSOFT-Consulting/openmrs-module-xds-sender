package org.openmrs.module.xdssender.api.cda.section.impl;

import org.marc.everest.datatypes.BL;
import org.marc.everest.datatypes.II;
import org.marc.everest.datatypes.generic.CE;
import org.marc.everest.datatypes.generic.LIST;
import org.marc.everest.rmim.uv.cdar2.pocd_mt000040uv.Entry;
import org.marc.everest.rmim.uv.cdar2.pocd_mt000040uv.Section;
import org.marc.everest.rmim.uv.cdar2.vocabulary.x_ActRelationshipEntry;
import org.openmrs.Allergy;
import org.openmrs.module.shr.cdahandler.CdaHandlerConstants;

import java.util.ArrayList;

/**
 * Generates allergies
 * 
 * @author JustinFyfe
 */
public class AllergiesIntolerancesSectionBuilder extends SectionBuilderImpl {
	
	/**
	 * Generate the active problems section
	 */
	@Override
	public Section generate(Entry... entries) {
		
		// TODO: Verify entries
		Section retVal = super.generate(entries);
		retVal.setTemplateId(LIST.createLIST(new II(CdaHandlerConstants.SCT_TEMPLATE_ALLERGIES), new II(
		        CdaHandlerConstants.SCT_TEMPLATE_CCD_ALERTS)));
		retVal.setTitle("Allergies and Other Adverse Reactions");
		retVal.setCode(new CE<String>("48765-2", CdaHandlerConstants.CODE_SYSTEM_LOINC, "LOINC", null,
		        "Allergies, adverse reactions, alerts", null));
		return retVal;
	}

	/**
	 * Generate the section with the specified problem list
	 *
	 * @return
	 */
	public Section generate(Allergy... allergy) {
		ArrayList<Entry> entries = new ArrayList<Entry>();

		AllergyConcernEntryBuilder builder = new AllergyConcernEntryBuilder();
		for (Allergy all : allergy) {
			Entry ent = new Entry(x_ActRelationshipEntry.HasComponent, BL.TRUE, builder.generate(all));
			entries.add(ent);
		}

		return this.generate(entries.toArray(new Entry[] {}));
	}
}
