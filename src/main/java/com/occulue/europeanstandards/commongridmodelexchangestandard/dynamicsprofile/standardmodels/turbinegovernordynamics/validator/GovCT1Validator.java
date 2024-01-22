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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class GovCT1Validator {

  /** default constructor */
  protected GovCT1Validator() {}

  /** factory method */
  public static GovCT1Validator getInstance() {
    return new GovCT1Validator();
  }

  /** handles creation validation for a GovCT1 */
  public void validate(CreateGovCT1Command govCT1) throws Exception {
    Assert.notNull(govCT1, "CreateGovCT1Command should not be null");
    //		Assert.isNull( govCT1.getGovCT1Id(), "CreateGovCT1Command identifier should be null" );
  }

  /** handles update validation for a GovCT1 */
  public void validate(UpdateGovCT1Command govCT1) throws Exception {
    Assert.notNull(govCT1, "UpdateGovCT1Command should not be null");
    Assert.notNull(govCT1.getGovCT1Id(), "UpdateGovCT1Command identifier should not be null");
  }

  /** handles delete validation for a GovCT1 */
  public void validate(DeleteGovCT1Command govCT1) throws Exception {
    Assert.notNull(govCT1, "{commandAlias} should not be null");
    Assert.notNull(govCT1.getGovCT1Id(), "DeleteGovCT1Command identifier should not be null");
  }

  /** handles fetchOne validation for a GovCT1 */
  public void validate(GovCT1FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GovCT1FetchOneSummary should not be null");
    Assert.notNull(summary.getGovCT1Id(), "GovCT1FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Aset validation for a GovCT1
   *
   * @param command AssignAsetToGovCT1Command
   */
  public void validate(AssignAsetToGovCT1Command command) throws Exception {
    Assert.notNull(command, "AssignAsetToGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "AssignAsetToGovCT1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignAsetToGovCT1Command assignment should not be null");
  }

  /**
   * handles unassign Aset validation for a GovCT1
   *
   * @param command UnAssignAsetFromGovCT1Command
   */
  public void validate(UnAssignAsetFromGovCT1Command command) throws Exception {
    Assert.notNull(command, "UnAssignAsetFromGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "UnAssignAsetFromGovCT1Command identifier should not be null");
  }
  /**
   * handles assign Db validation for a GovCT1
   *
   * @param command AssignDbToGovCT1Command
   */
  public void validate(AssignDbToGovCT1Command command) throws Exception {
    Assert.notNull(command, "AssignDbToGovCT1Command should not be null");
    Assert.notNull(command.getGovCT1Id(), "AssignDbToGovCT1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDbToGovCT1Command assignment should not be null");
  }

  /**
   * handles unassign Db validation for a GovCT1
   *
   * @param command UnAssignDbFromGovCT1Command
   */
  public void validate(UnAssignDbFromGovCT1Command command) throws Exception {
    Assert.notNull(command, "UnAssignDbFromGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "UnAssignDbFromGovCT1Command identifier should not be null");
  }
  /**
   * handles assign Dm validation for a GovCT1
   *
   * @param command AssignDmToGovCT1Command
   */
  public void validate(AssignDmToGovCT1Command command) throws Exception {
    Assert.notNull(command, "AssignDmToGovCT1Command should not be null");
    Assert.notNull(command.getGovCT1Id(), "AssignDmToGovCT1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDmToGovCT1Command assignment should not be null");
  }

  /**
   * handles unassign Dm validation for a GovCT1
   *
   * @param command UnAssignDmFromGovCT1Command
   */
  public void validate(UnAssignDmFromGovCT1Command command) throws Exception {
    Assert.notNull(command, "UnAssignDmFromGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "UnAssignDmFromGovCT1Command identifier should not be null");
  }
  /**
   * handles assign Ka validation for a GovCT1
   *
   * @param command AssignKaToGovCT1Command
   */
  public void validate(AssignKaToGovCT1Command command) throws Exception {
    Assert.notNull(command, "AssignKaToGovCT1Command should not be null");
    Assert.notNull(command.getGovCT1Id(), "AssignKaToGovCT1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToGovCT1Command assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a GovCT1
   *
   * @param command UnAssignKaFromGovCT1Command
   */
  public void validate(UnAssignKaFromGovCT1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "UnAssignKaFromGovCT1Command identifier should not be null");
  }
  /**
   * handles assign Kdgov validation for a GovCT1
   *
   * @param command AssignKdgovToGovCT1Command
   */
  public void validate(AssignKdgovToGovCT1Command command) throws Exception {
    Assert.notNull(command, "AssignKdgovToGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "AssignKdgovToGovCT1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKdgovToGovCT1Command assignment should not be null");
  }

  /**
   * handles unassign Kdgov validation for a GovCT1
   *
   * @param command UnAssignKdgovFromGovCT1Command
   */
  public void validate(UnAssignKdgovFromGovCT1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKdgovFromGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "UnAssignKdgovFromGovCT1Command identifier should not be null");
  }
  /**
   * handles assign Kigov validation for a GovCT1
   *
   * @param command AssignKigovToGovCT1Command
   */
  public void validate(AssignKigovToGovCT1Command command) throws Exception {
    Assert.notNull(command, "AssignKigovToGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "AssignKigovToGovCT1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKigovToGovCT1Command assignment should not be null");
  }

  /**
   * handles unassign Kigov validation for a GovCT1
   *
   * @param command UnAssignKigovFromGovCT1Command
   */
  public void validate(UnAssignKigovFromGovCT1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKigovFromGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "UnAssignKigovFromGovCT1Command identifier should not be null");
  }
  /**
   * handles assign Kiload validation for a GovCT1
   *
   * @param command AssignKiloadToGovCT1Command
   */
  public void validate(AssignKiloadToGovCT1Command command) throws Exception {
    Assert.notNull(command, "AssignKiloadToGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "AssignKiloadToGovCT1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKiloadToGovCT1Command assignment should not be null");
  }

  /**
   * handles unassign Kiload validation for a GovCT1
   *
   * @param command UnAssignKiloadFromGovCT1Command
   */
  public void validate(UnAssignKiloadFromGovCT1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKiloadFromGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "UnAssignKiloadFromGovCT1Command identifier should not be null");
  }
  /**
   * handles assign Kimw validation for a GovCT1
   *
   * @param command AssignKimwToGovCT1Command
   */
  public void validate(AssignKimwToGovCT1Command command) throws Exception {
    Assert.notNull(command, "AssignKimwToGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "AssignKimwToGovCT1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKimwToGovCT1Command assignment should not be null");
  }

  /**
   * handles unassign Kimw validation for a GovCT1
   *
   * @param command UnAssignKimwFromGovCT1Command
   */
  public void validate(UnAssignKimwFromGovCT1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKimwFromGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "UnAssignKimwFromGovCT1Command identifier should not be null");
  }
  /**
   * handles assign Kpgov validation for a GovCT1
   *
   * @param command AssignKpgovToGovCT1Command
   */
  public void validate(AssignKpgovToGovCT1Command command) throws Exception {
    Assert.notNull(command, "AssignKpgovToGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "AssignKpgovToGovCT1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKpgovToGovCT1Command assignment should not be null");
  }

  /**
   * handles unassign Kpgov validation for a GovCT1
   *
   * @param command UnAssignKpgovFromGovCT1Command
   */
  public void validate(UnAssignKpgovFromGovCT1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKpgovFromGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "UnAssignKpgovFromGovCT1Command identifier should not be null");
  }
  /**
   * handles assign Kpload validation for a GovCT1
   *
   * @param command AssignKploadToGovCT1Command
   */
  public void validate(AssignKploadToGovCT1Command command) throws Exception {
    Assert.notNull(command, "AssignKploadToGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "AssignKploadToGovCT1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKploadToGovCT1Command assignment should not be null");
  }

  /**
   * handles unassign Kpload validation for a GovCT1
   *
   * @param command UnAssignKploadFromGovCT1Command
   */
  public void validate(UnAssignKploadFromGovCT1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKploadFromGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "UnAssignKploadFromGovCT1Command identifier should not be null");
  }
  /**
   * handles assign Kturb validation for a GovCT1
   *
   * @param command AssignKturbToGovCT1Command
   */
  public void validate(AssignKturbToGovCT1Command command) throws Exception {
    Assert.notNull(command, "AssignKturbToGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "AssignKturbToGovCT1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKturbToGovCT1Command assignment should not be null");
  }

  /**
   * handles unassign Kturb validation for a GovCT1
   *
   * @param command UnAssignKturbFromGovCT1Command
   */
  public void validate(UnAssignKturbFromGovCT1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKturbFromGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "UnAssignKturbFromGovCT1Command identifier should not be null");
  }
  /**
   * handles assign Ldref validation for a GovCT1
   *
   * @param command AssignLdrefToGovCT1Command
   */
  public void validate(AssignLdrefToGovCT1Command command) throws Exception {
    Assert.notNull(command, "AssignLdrefToGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "AssignLdrefToGovCT1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignLdrefToGovCT1Command assignment should not be null");
  }

  /**
   * handles unassign Ldref validation for a GovCT1
   *
   * @param command UnAssignLdrefFromGovCT1Command
   */
  public void validate(UnAssignLdrefFromGovCT1Command command) throws Exception {
    Assert.notNull(command, "UnAssignLdrefFromGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "UnAssignLdrefFromGovCT1Command identifier should not be null");
  }
  /**
   * handles assign Maxerr validation for a GovCT1
   *
   * @param command AssignMaxerrToGovCT1Command
   */
  public void validate(AssignMaxerrToGovCT1Command command) throws Exception {
    Assert.notNull(command, "AssignMaxerrToGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "AssignMaxerrToGovCT1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMaxerrToGovCT1Command assignment should not be null");
  }

  /**
   * handles unassign Maxerr validation for a GovCT1
   *
   * @param command UnAssignMaxerrFromGovCT1Command
   */
  public void validate(UnAssignMaxerrFromGovCT1Command command) throws Exception {
    Assert.notNull(command, "UnAssignMaxerrFromGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "UnAssignMaxerrFromGovCT1Command identifier should not be null");
  }
  /**
   * handles assign Minerr validation for a GovCT1
   *
   * @param command AssignMinerrToGovCT1Command
   */
  public void validate(AssignMinerrToGovCT1Command command) throws Exception {
    Assert.notNull(command, "AssignMinerrToGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "AssignMinerrToGovCT1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMinerrToGovCT1Command assignment should not be null");
  }

  /**
   * handles unassign Minerr validation for a GovCT1
   *
   * @param command UnAssignMinerrFromGovCT1Command
   */
  public void validate(UnAssignMinerrFromGovCT1Command command) throws Exception {
    Assert.notNull(command, "UnAssignMinerrFromGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "UnAssignMinerrFromGovCT1Command identifier should not be null");
  }
  /**
   * handles assign Mwbase validation for a GovCT1
   *
   * @param command AssignMwbaseToGovCT1Command
   */
  public void validate(AssignMwbaseToGovCT1Command command) throws Exception {
    Assert.notNull(command, "AssignMwbaseToGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "AssignMwbaseToGovCT1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMwbaseToGovCT1Command assignment should not be null");
  }

  /**
   * handles unassign Mwbase validation for a GovCT1
   *
   * @param command UnAssignMwbaseFromGovCT1Command
   */
  public void validate(UnAssignMwbaseFromGovCT1Command command) throws Exception {
    Assert.notNull(command, "UnAssignMwbaseFromGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "UnAssignMwbaseFromGovCT1Command identifier should not be null");
  }
  /**
   * handles assign R validation for a GovCT1
   *
   * @param command AssignRToGovCT1Command
   */
  public void validate(AssignRToGovCT1Command command) throws Exception {
    Assert.notNull(command, "AssignRToGovCT1Command should not be null");
    Assert.notNull(command.getGovCT1Id(), "AssignRToGovCT1Command identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignRToGovCT1Command assignment should not be null");
  }

  /**
   * handles unassign R validation for a GovCT1
   *
   * @param command UnAssignRFromGovCT1Command
   */
  public void validate(UnAssignRFromGovCT1Command command) throws Exception {
    Assert.notNull(command, "UnAssignRFromGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "UnAssignRFromGovCT1Command identifier should not be null");
  }
  /**
   * handles assign Rclose validation for a GovCT1
   *
   * @param command AssignRcloseToGovCT1Command
   */
  public void validate(AssignRcloseToGovCT1Command command) throws Exception {
    Assert.notNull(command, "AssignRcloseToGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "AssignRcloseToGovCT1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRcloseToGovCT1Command assignment should not be null");
  }

  /**
   * handles unassign Rclose validation for a GovCT1
   *
   * @param command UnAssignRcloseFromGovCT1Command
   */
  public void validate(UnAssignRcloseFromGovCT1Command command) throws Exception {
    Assert.notNull(command, "UnAssignRcloseFromGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "UnAssignRcloseFromGovCT1Command identifier should not be null");
  }
  /**
   * handles assign Rdown validation for a GovCT1
   *
   * @param command AssignRdownToGovCT1Command
   */
  public void validate(AssignRdownToGovCT1Command command) throws Exception {
    Assert.notNull(command, "AssignRdownToGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "AssignRdownToGovCT1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRdownToGovCT1Command assignment should not be null");
  }

  /**
   * handles unassign Rdown validation for a GovCT1
   *
   * @param command UnAssignRdownFromGovCT1Command
   */
  public void validate(UnAssignRdownFromGovCT1Command command) throws Exception {
    Assert.notNull(command, "UnAssignRdownFromGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "UnAssignRdownFromGovCT1Command identifier should not be null");
  }
  /**
   * handles assign Ropen validation for a GovCT1
   *
   * @param command AssignRopenToGovCT1Command
   */
  public void validate(AssignRopenToGovCT1Command command) throws Exception {
    Assert.notNull(command, "AssignRopenToGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "AssignRopenToGovCT1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRopenToGovCT1Command assignment should not be null");
  }

  /**
   * handles unassign Ropen validation for a GovCT1
   *
   * @param command UnAssignRopenFromGovCT1Command
   */
  public void validate(UnAssignRopenFromGovCT1Command command) throws Exception {
    Assert.notNull(command, "UnAssignRopenFromGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "UnAssignRopenFromGovCT1Command identifier should not be null");
  }
  /**
   * handles assign Rup validation for a GovCT1
   *
   * @param command AssignRupToGovCT1Command
   */
  public void validate(AssignRupToGovCT1Command command) throws Exception {
    Assert.notNull(command, "AssignRupToGovCT1Command should not be null");
    Assert.notNull(command.getGovCT1Id(), "AssignRupToGovCT1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRupToGovCT1Command assignment should not be null");
  }

  /**
   * handles unassign Rup validation for a GovCT1
   *
   * @param command UnAssignRupFromGovCT1Command
   */
  public void validate(UnAssignRupFromGovCT1Command command) throws Exception {
    Assert.notNull(command, "UnAssignRupFromGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "UnAssignRupFromGovCT1Command identifier should not be null");
  }
  /**
   * handles assign Ta validation for a GovCT1
   *
   * @param command AssignTaToGovCT1Command
   */
  public void validate(AssignTaToGovCT1Command command) throws Exception {
    Assert.notNull(command, "AssignTaToGovCT1Command should not be null");
    Assert.notNull(command.getGovCT1Id(), "AssignTaToGovCT1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToGovCT1Command assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a GovCT1
   *
   * @param command UnAssignTaFromGovCT1Command
   */
  public void validate(UnAssignTaFromGovCT1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "UnAssignTaFromGovCT1Command identifier should not be null");
  }
  /**
   * handles assign Tact validation for a GovCT1
   *
   * @param command AssignTactToGovCT1Command
   */
  public void validate(AssignTactToGovCT1Command command) throws Exception {
    Assert.notNull(command, "AssignTactToGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "AssignTactToGovCT1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTactToGovCT1Command assignment should not be null");
  }

  /**
   * handles unassign Tact validation for a GovCT1
   *
   * @param command UnAssignTactFromGovCT1Command
   */
  public void validate(UnAssignTactFromGovCT1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTactFromGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "UnAssignTactFromGovCT1Command identifier should not be null");
  }
  /**
   * handles assign Tb validation for a GovCT1
   *
   * @param command AssignTbToGovCT1Command
   */
  public void validate(AssignTbToGovCT1Command command) throws Exception {
    Assert.notNull(command, "AssignTbToGovCT1Command should not be null");
    Assert.notNull(command.getGovCT1Id(), "AssignTbToGovCT1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToGovCT1Command assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a GovCT1
   *
   * @param command UnAssignTbFromGovCT1Command
   */
  public void validate(UnAssignTbFromGovCT1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "UnAssignTbFromGovCT1Command identifier should not be null");
  }
  /**
   * handles assign Tc validation for a GovCT1
   *
   * @param command AssignTcToGovCT1Command
   */
  public void validate(AssignTcToGovCT1Command command) throws Exception {
    Assert.notNull(command, "AssignTcToGovCT1Command should not be null");
    Assert.notNull(command.getGovCT1Id(), "AssignTcToGovCT1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcToGovCT1Command assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a GovCT1
   *
   * @param command UnAssignTcFromGovCT1Command
   */
  public void validate(UnAssignTcFromGovCT1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "UnAssignTcFromGovCT1Command identifier should not be null");
  }
  /**
   * handles assign Tdgov validation for a GovCT1
   *
   * @param command AssignTdgovToGovCT1Command
   */
  public void validate(AssignTdgovToGovCT1Command command) throws Exception {
    Assert.notNull(command, "AssignTdgovToGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "AssignTdgovToGovCT1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTdgovToGovCT1Command assignment should not be null");
  }

  /**
   * handles unassign Tdgov validation for a GovCT1
   *
   * @param command UnAssignTdgovFromGovCT1Command
   */
  public void validate(UnAssignTdgovFromGovCT1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTdgovFromGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "UnAssignTdgovFromGovCT1Command identifier should not be null");
  }
  /**
   * handles assign Teng validation for a GovCT1
   *
   * @param command AssignTengToGovCT1Command
   */
  public void validate(AssignTengToGovCT1Command command) throws Exception {
    Assert.notNull(command, "AssignTengToGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "AssignTengToGovCT1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTengToGovCT1Command assignment should not be null");
  }

  /**
   * handles unassign Teng validation for a GovCT1
   *
   * @param command UnAssignTengFromGovCT1Command
   */
  public void validate(UnAssignTengFromGovCT1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTengFromGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "UnAssignTengFromGovCT1Command identifier should not be null");
  }
  /**
   * handles assign Tfload validation for a GovCT1
   *
   * @param command AssignTfloadToGovCT1Command
   */
  public void validate(AssignTfloadToGovCT1Command command) throws Exception {
    Assert.notNull(command, "AssignTfloadToGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "AssignTfloadToGovCT1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfloadToGovCT1Command assignment should not be null");
  }

  /**
   * handles unassign Tfload validation for a GovCT1
   *
   * @param command UnAssignTfloadFromGovCT1Command
   */
  public void validate(UnAssignTfloadFromGovCT1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTfloadFromGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "UnAssignTfloadFromGovCT1Command identifier should not be null");
  }
  /**
   * handles assign Tpelec validation for a GovCT1
   *
   * @param command AssignTpelecToGovCT1Command
   */
  public void validate(AssignTpelecToGovCT1Command command) throws Exception {
    Assert.notNull(command, "AssignTpelecToGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "AssignTpelecToGovCT1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTpelecToGovCT1Command assignment should not be null");
  }

  /**
   * handles unassign Tpelec validation for a GovCT1
   *
   * @param command UnAssignTpelecFromGovCT1Command
   */
  public void validate(UnAssignTpelecFromGovCT1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTpelecFromGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "UnAssignTpelecFromGovCT1Command identifier should not be null");
  }
  /**
   * handles assign Tsa validation for a GovCT1
   *
   * @param command AssignTsaToGovCT1Command
   */
  public void validate(AssignTsaToGovCT1Command command) throws Exception {
    Assert.notNull(command, "AssignTsaToGovCT1Command should not be null");
    Assert.notNull(command.getGovCT1Id(), "AssignTsaToGovCT1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTsaToGovCT1Command assignment should not be null");
  }

  /**
   * handles unassign Tsa validation for a GovCT1
   *
   * @param command UnAssignTsaFromGovCT1Command
   */
  public void validate(UnAssignTsaFromGovCT1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTsaFromGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "UnAssignTsaFromGovCT1Command identifier should not be null");
  }
  /**
   * handles assign Tsb validation for a GovCT1
   *
   * @param command AssignTsbToGovCT1Command
   */
  public void validate(AssignTsbToGovCT1Command command) throws Exception {
    Assert.notNull(command, "AssignTsbToGovCT1Command should not be null");
    Assert.notNull(command.getGovCT1Id(), "AssignTsbToGovCT1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTsbToGovCT1Command assignment should not be null");
  }

  /**
   * handles unassign Tsb validation for a GovCT1
   *
   * @param command UnAssignTsbFromGovCT1Command
   */
  public void validate(UnAssignTsbFromGovCT1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTsbFromGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "UnAssignTsbFromGovCT1Command identifier should not be null");
  }
  /**
   * handles assign Vmax validation for a GovCT1
   *
   * @param command AssignVmaxToGovCT1Command
   */
  public void validate(AssignVmaxToGovCT1Command command) throws Exception {
    Assert.notNull(command, "AssignVmaxToGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "AssignVmaxToGovCT1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVmaxToGovCT1Command assignment should not be null");
  }

  /**
   * handles unassign Vmax validation for a GovCT1
   *
   * @param command UnAssignVmaxFromGovCT1Command
   */
  public void validate(UnAssignVmaxFromGovCT1Command command) throws Exception {
    Assert.notNull(command, "UnAssignVmaxFromGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "UnAssignVmaxFromGovCT1Command identifier should not be null");
  }
  /**
   * handles assign Vmin validation for a GovCT1
   *
   * @param command AssignVminToGovCT1Command
   */
  public void validate(AssignVminToGovCT1Command command) throws Exception {
    Assert.notNull(command, "AssignVminToGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "AssignVminToGovCT1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVminToGovCT1Command assignment should not be null");
  }

  /**
   * handles unassign Vmin validation for a GovCT1
   *
   * @param command UnAssignVminFromGovCT1Command
   */
  public void validate(UnAssignVminFromGovCT1Command command) throws Exception {
    Assert.notNull(command, "UnAssignVminFromGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "UnAssignVminFromGovCT1Command identifier should not be null");
  }
  /**
   * handles assign Wfnl validation for a GovCT1
   *
   * @param command AssignWfnlToGovCT1Command
   */
  public void validate(AssignWfnlToGovCT1Command command) throws Exception {
    Assert.notNull(command, "AssignWfnlToGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "AssignWfnlToGovCT1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignWfnlToGovCT1Command assignment should not be null");
  }

  /**
   * handles unassign Wfnl validation for a GovCT1
   *
   * @param command UnAssignWfnlFromGovCT1Command
   */
  public void validate(UnAssignWfnlFromGovCT1Command command) throws Exception {
    Assert.notNull(command, "UnAssignWfnlFromGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "UnAssignWfnlFromGovCT1Command identifier should not be null");
  }
  /**
   * handles assign Wfspd validation for a GovCT1
   *
   * @param command AssignWfspdToGovCT1Command
   */
  public void validate(AssignWfspdToGovCT1Command command) throws Exception {
    Assert.notNull(command, "AssignWfspdToGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "AssignWfspdToGovCT1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignWfspdToGovCT1Command assignment should not be null");
  }

  /**
   * handles unassign Wfspd validation for a GovCT1
   *
   * @param command UnAssignWfspdFromGovCT1Command
   */
  public void validate(UnAssignWfspdFromGovCT1Command command) throws Exception {
    Assert.notNull(command, "UnAssignWfspdFromGovCT1Command should not be null");
    Assert.notNull(
        command.getGovCT1Id(), "UnAssignWfspdFromGovCT1Command identifier should not be null");
  }
}
