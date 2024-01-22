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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.equivalents.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class EquivalentEquipmentValidator {

  /** default constructor */
  protected EquivalentEquipmentValidator() {}

  /** factory method */
  public static EquivalentEquipmentValidator getInstance() {
    return new EquivalentEquipmentValidator();
  }

  /** handles creation validation for a EquivalentEquipment */
  public void validate(CreateEquivalentEquipmentCommand equivalentEquipment) throws Exception {
    Assert.notNull(equivalentEquipment, "CreateEquivalentEquipmentCommand should not be null");
    //		Assert.isNull( equivalentEquipment.getEquivalentEquipmentId(),
    // "CreateEquivalentEquipmentCommand identifier should be null" );
  }

  /** handles update validation for a EquivalentEquipment */
  public void validate(UpdateEquivalentEquipmentCommand equivalentEquipment) throws Exception {
    Assert.notNull(equivalentEquipment, "UpdateEquivalentEquipmentCommand should not be null");
    Assert.notNull(
        equivalentEquipment.getEquivalentEquipmentId(),
        "UpdateEquivalentEquipmentCommand identifier should not be null");
  }

  /** handles delete validation for a EquivalentEquipment */
  public void validate(DeleteEquivalentEquipmentCommand equivalentEquipment) throws Exception {
    Assert.notNull(equivalentEquipment, "{commandAlias} should not be null");
    Assert.notNull(
        equivalentEquipment.getEquivalentEquipmentId(),
        "DeleteEquivalentEquipmentCommand identifier should not be null");
  }

  /** handles fetchOne validation for a EquivalentEquipment */
  public void validate(EquivalentEquipmentFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "EquivalentEquipmentFetchOneSummary should not be null");
    Assert.notNull(
        summary.getEquivalentEquipmentId(),
        "EquivalentEquipmentFetchOneSummary identifier should not be null");
  }

  /**
   * handles add to EquivalentEquipments validation for a EquivalentEquipment
   *
   * @param command AssignEquivalentEquipmentsToEquivalentEquipmentCommand
   */
  public void validate(AssignEquivalentEquipmentsToEquivalentEquipmentCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignEquivalentEquipmentsToEquivalentEquipmentCommand should not be null");
    Assert.notNull(
        command.getEquivalentEquipmentId(),
        "AssignEquivalentEquipmentsToEquivalentEquipmentCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignEquivalentEquipmentsToEquivalentEquipmentCommand addTo attribute should not be null");
  }

  /**
   * handles remove from EquivalentEquipments validation for a EquivalentEquipment
   *
   * @param command RemoveEquivalentEquipmentsFromEquivalentEquipmentCommand
   */
  public void validate(RemoveEquivalentEquipmentsFromEquivalentEquipmentCommand command)
      throws Exception {
    Assert.notNull(
        command, "RemoveEquivalentEquipmentsFromEquivalentEquipmentCommand should not be null");
    Assert.notNull(
        command.getEquivalentEquipmentId(),
        "RemoveEquivalentEquipmentsFromEquivalentEquipmentCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveEquivalentEquipmentsFromEquivalentEquipmentCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getEquivalentEquipmentId(),
        "RemoveEquivalentEquipmentsFromEquivalentEquipmentCommand removeFrom attribubte identifier should not be null");
  }
}
