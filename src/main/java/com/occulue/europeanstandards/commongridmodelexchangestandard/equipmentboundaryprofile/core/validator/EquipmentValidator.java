/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class EquipmentValidator {

  /** default constructor */
  protected EquipmentValidator() {}

  /** factory method */
  public static EquipmentValidator getInstance() {
    return new EquipmentValidator();
  }

  /** handles creation validation for a Equipment */
  public void validate(CreateEquipmentCommand equipment) throws Exception {
    Assert.notNull(equipment, "CreateEquipmentCommand should not be null");
    //		Assert.isNull( equipment.getEquipmentId(), "CreateEquipmentCommand identifier should be
    // null" );
  }

  /** handles update validation for a Equipment */
  public void validate(UpdateEquipmentCommand equipment) throws Exception {
    Assert.notNull(equipment, "UpdateEquipmentCommand should not be null");
    Assert.notNull(
        equipment.getEquipmentId(), "UpdateEquipmentCommand identifier should not be null");
  }

  /** handles delete validation for a Equipment */
  public void validate(DeleteEquipmentCommand equipment) throws Exception {
    Assert.notNull(equipment, "{commandAlias} should not be null");
    Assert.notNull(
        equipment.getEquipmentId(), "DeleteEquipmentCommand identifier should not be null");
  }

  /** handles fetchOne validation for a Equipment */
  public void validate(EquipmentFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "EquipmentFetchOneSummary should not be null");
    Assert.notNull(
        summary.getEquipmentId(), "EquipmentFetchOneSummary identifier should not be null");
  }

  /**
   * handles add to Equipments validation for a Equipment
   *
   * @param command AssignEquipmentsToEquipmentCommand
   */
  public void validate(AssignEquipmentsToEquipmentCommand command) throws Exception {
    Assert.notNull(command, "AssignEquipmentsToEquipmentCommand should not be null");
    Assert.notNull(
        command.getEquipmentId(),
        "AssignEquipmentsToEquipmentCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignEquipmentsToEquipmentCommand addTo attribute should not be null");
  }

  /**
   * handles remove from Equipments validation for a Equipment
   *
   * @param command RemoveEquipmentsFromEquipmentCommand
   */
  public void validate(RemoveEquipmentsFromEquipmentCommand command) throws Exception {
    Assert.notNull(command, "RemoveEquipmentsFromEquipmentCommand should not be null");
    Assert.notNull(
        command.getEquipmentId(),
        "RemoveEquipmentsFromEquipmentCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveEquipmentsFromEquipmentCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getEquipmentId(),
        "RemoveEquipmentsFromEquipmentCommand removeFrom attribubte identifier should not be null");
  }
}
