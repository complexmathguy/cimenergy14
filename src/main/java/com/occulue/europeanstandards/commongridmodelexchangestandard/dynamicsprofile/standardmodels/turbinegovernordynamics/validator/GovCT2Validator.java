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

public class GovCT2Validator {

  /** default constructor */
  protected GovCT2Validator() {}

  /** factory method */
  public static GovCT2Validator getInstance() {
    return new GovCT2Validator();
  }

  /** handles creation validation for a GovCT2 */
  public void validate(CreateGovCT2Command govCT2) throws Exception {
    Assert.notNull(govCT2, "CreateGovCT2Command should not be null");
    //		Assert.isNull( govCT2.getGovCT2Id(), "CreateGovCT2Command identifier should be null" );
  }

  /** handles update validation for a GovCT2 */
  public void validate(UpdateGovCT2Command govCT2) throws Exception {
    Assert.notNull(govCT2, "UpdateGovCT2Command should not be null");
    Assert.notNull(govCT2.getGovCT2Id(), "UpdateGovCT2Command identifier should not be null");
  }

  /** handles delete validation for a GovCT2 */
  public void validate(DeleteGovCT2Command govCT2) throws Exception {
    Assert.notNull(govCT2, "{commandAlias} should not be null");
    Assert.notNull(govCT2.getGovCT2Id(), "DeleteGovCT2Command identifier should not be null");
  }

  /** handles fetchOne validation for a GovCT2 */
  public void validate(GovCT2FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GovCT2FetchOneSummary should not be null");
    Assert.notNull(summary.getGovCT2Id(), "GovCT2FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Aset validation for a GovCT2
   *
   * @param command AssignAsetToGovCT2Command
   */
  public void validate(AssignAsetToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignAsetToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignAsetToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignAsetToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Aset validation for a GovCT2
   *
   * @param command UnAssignAsetFromGovCT2Command
   */
  public void validate(UnAssignAsetFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignAsetFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignAsetFromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Db validation for a GovCT2
   *
   * @param command AssignDbToGovCT2Command
   */
  public void validate(AssignDbToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignDbToGovCT2Command should not be null");
    Assert.notNull(command.getGovCT2Id(), "AssignDbToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDbToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Db validation for a GovCT2
   *
   * @param command UnAssignDbFromGovCT2Command
   */
  public void validate(UnAssignDbFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignDbFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignDbFromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Dm validation for a GovCT2
   *
   * @param command AssignDmToGovCT2Command
   */
  public void validate(AssignDmToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignDmToGovCT2Command should not be null");
    Assert.notNull(command.getGovCT2Id(), "AssignDmToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDmToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Dm validation for a GovCT2
   *
   * @param command UnAssignDmFromGovCT2Command
   */
  public void validate(UnAssignDmFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignDmFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignDmFromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Flim1 validation for a GovCT2
   *
   * @param command AssignFlim1ToGovCT2Command
   */
  public void validate(AssignFlim1ToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignFlim1ToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignFlim1ToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignFlim1ToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Flim1 validation for a GovCT2
   *
   * @param command UnAssignFlim1FromGovCT2Command
   */
  public void validate(UnAssignFlim1FromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignFlim1FromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignFlim1FromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Flim10 validation for a GovCT2
   *
   * @param command AssignFlim10ToGovCT2Command
   */
  public void validate(AssignFlim10ToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignFlim10ToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignFlim10ToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignFlim10ToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Flim10 validation for a GovCT2
   *
   * @param command UnAssignFlim10FromGovCT2Command
   */
  public void validate(UnAssignFlim10FromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignFlim10FromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignFlim10FromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Flim2 validation for a GovCT2
   *
   * @param command AssignFlim2ToGovCT2Command
   */
  public void validate(AssignFlim2ToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignFlim2ToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignFlim2ToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignFlim2ToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Flim2 validation for a GovCT2
   *
   * @param command UnAssignFlim2FromGovCT2Command
   */
  public void validate(UnAssignFlim2FromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignFlim2FromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignFlim2FromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Flim3 validation for a GovCT2
   *
   * @param command AssignFlim3ToGovCT2Command
   */
  public void validate(AssignFlim3ToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignFlim3ToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignFlim3ToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignFlim3ToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Flim3 validation for a GovCT2
   *
   * @param command UnAssignFlim3FromGovCT2Command
   */
  public void validate(UnAssignFlim3FromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignFlim3FromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignFlim3FromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Flim4 validation for a GovCT2
   *
   * @param command AssignFlim4ToGovCT2Command
   */
  public void validate(AssignFlim4ToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignFlim4ToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignFlim4ToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignFlim4ToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Flim4 validation for a GovCT2
   *
   * @param command UnAssignFlim4FromGovCT2Command
   */
  public void validate(UnAssignFlim4FromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignFlim4FromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignFlim4FromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Flim5 validation for a GovCT2
   *
   * @param command AssignFlim5ToGovCT2Command
   */
  public void validate(AssignFlim5ToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignFlim5ToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignFlim5ToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignFlim5ToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Flim5 validation for a GovCT2
   *
   * @param command UnAssignFlim5FromGovCT2Command
   */
  public void validate(UnAssignFlim5FromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignFlim5FromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignFlim5FromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Flim6 validation for a GovCT2
   *
   * @param command AssignFlim6ToGovCT2Command
   */
  public void validate(AssignFlim6ToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignFlim6ToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignFlim6ToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignFlim6ToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Flim6 validation for a GovCT2
   *
   * @param command UnAssignFlim6FromGovCT2Command
   */
  public void validate(UnAssignFlim6FromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignFlim6FromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignFlim6FromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Flim7 validation for a GovCT2
   *
   * @param command AssignFlim7ToGovCT2Command
   */
  public void validate(AssignFlim7ToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignFlim7ToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignFlim7ToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignFlim7ToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Flim7 validation for a GovCT2
   *
   * @param command UnAssignFlim7FromGovCT2Command
   */
  public void validate(UnAssignFlim7FromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignFlim7FromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignFlim7FromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Flim8 validation for a GovCT2
   *
   * @param command AssignFlim8ToGovCT2Command
   */
  public void validate(AssignFlim8ToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignFlim8ToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignFlim8ToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignFlim8ToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Flim8 validation for a GovCT2
   *
   * @param command UnAssignFlim8FromGovCT2Command
   */
  public void validate(UnAssignFlim8FromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignFlim8FromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignFlim8FromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Flim9 validation for a GovCT2
   *
   * @param command AssignFlim9ToGovCT2Command
   */
  public void validate(AssignFlim9ToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignFlim9ToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignFlim9ToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignFlim9ToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Flim9 validation for a GovCT2
   *
   * @param command UnAssignFlim9FromGovCT2Command
   */
  public void validate(UnAssignFlim9FromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignFlim9FromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignFlim9FromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Ka validation for a GovCT2
   *
   * @param command AssignKaToGovCT2Command
   */
  public void validate(AssignKaToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignKaToGovCT2Command should not be null");
    Assert.notNull(command.getGovCT2Id(), "AssignKaToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a GovCT2
   *
   * @param command UnAssignKaFromGovCT2Command
   */
  public void validate(UnAssignKaFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignKaFromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Kdgov validation for a GovCT2
   *
   * @param command AssignKdgovToGovCT2Command
   */
  public void validate(AssignKdgovToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignKdgovToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignKdgovToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKdgovToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Kdgov validation for a GovCT2
   *
   * @param command UnAssignKdgovFromGovCT2Command
   */
  public void validate(UnAssignKdgovFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignKdgovFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignKdgovFromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Kigov validation for a GovCT2
   *
   * @param command AssignKigovToGovCT2Command
   */
  public void validate(AssignKigovToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignKigovToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignKigovToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKigovToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Kigov validation for a GovCT2
   *
   * @param command UnAssignKigovFromGovCT2Command
   */
  public void validate(UnAssignKigovFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignKigovFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignKigovFromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Kiload validation for a GovCT2
   *
   * @param command AssignKiloadToGovCT2Command
   */
  public void validate(AssignKiloadToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignKiloadToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignKiloadToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKiloadToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Kiload validation for a GovCT2
   *
   * @param command UnAssignKiloadFromGovCT2Command
   */
  public void validate(UnAssignKiloadFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignKiloadFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignKiloadFromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Kimw validation for a GovCT2
   *
   * @param command AssignKimwToGovCT2Command
   */
  public void validate(AssignKimwToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignKimwToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignKimwToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKimwToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Kimw validation for a GovCT2
   *
   * @param command UnAssignKimwFromGovCT2Command
   */
  public void validate(UnAssignKimwFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignKimwFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignKimwFromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Kpgov validation for a GovCT2
   *
   * @param command AssignKpgovToGovCT2Command
   */
  public void validate(AssignKpgovToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignKpgovToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignKpgovToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKpgovToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Kpgov validation for a GovCT2
   *
   * @param command UnAssignKpgovFromGovCT2Command
   */
  public void validate(UnAssignKpgovFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignKpgovFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignKpgovFromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Kpload validation for a GovCT2
   *
   * @param command AssignKploadToGovCT2Command
   */
  public void validate(AssignKploadToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignKploadToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignKploadToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKploadToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Kpload validation for a GovCT2
   *
   * @param command UnAssignKploadFromGovCT2Command
   */
  public void validate(UnAssignKploadFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignKploadFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignKploadFromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Kturb validation for a GovCT2
   *
   * @param command AssignKturbToGovCT2Command
   */
  public void validate(AssignKturbToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignKturbToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignKturbToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKturbToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Kturb validation for a GovCT2
   *
   * @param command UnAssignKturbFromGovCT2Command
   */
  public void validate(UnAssignKturbFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignKturbFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignKturbFromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Ldref validation for a GovCT2
   *
   * @param command AssignLdrefToGovCT2Command
   */
  public void validate(AssignLdrefToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignLdrefToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignLdrefToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignLdrefToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Ldref validation for a GovCT2
   *
   * @param command UnAssignLdrefFromGovCT2Command
   */
  public void validate(UnAssignLdrefFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignLdrefFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignLdrefFromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Maxerr validation for a GovCT2
   *
   * @param command AssignMaxerrToGovCT2Command
   */
  public void validate(AssignMaxerrToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignMaxerrToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignMaxerrToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMaxerrToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Maxerr validation for a GovCT2
   *
   * @param command UnAssignMaxerrFromGovCT2Command
   */
  public void validate(UnAssignMaxerrFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignMaxerrFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignMaxerrFromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Minerr validation for a GovCT2
   *
   * @param command AssignMinerrToGovCT2Command
   */
  public void validate(AssignMinerrToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignMinerrToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignMinerrToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMinerrToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Minerr validation for a GovCT2
   *
   * @param command UnAssignMinerrFromGovCT2Command
   */
  public void validate(UnAssignMinerrFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignMinerrFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignMinerrFromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Mwbase validation for a GovCT2
   *
   * @param command AssignMwbaseToGovCT2Command
   */
  public void validate(AssignMwbaseToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignMwbaseToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignMwbaseToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMwbaseToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Mwbase validation for a GovCT2
   *
   * @param command UnAssignMwbaseFromGovCT2Command
   */
  public void validate(UnAssignMwbaseFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignMwbaseFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignMwbaseFromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Plim1 validation for a GovCT2
   *
   * @param command AssignPlim1ToGovCT2Command
   */
  public void validate(AssignPlim1ToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignPlim1ToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignPlim1ToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPlim1ToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Plim1 validation for a GovCT2
   *
   * @param command UnAssignPlim1FromGovCT2Command
   */
  public void validate(UnAssignPlim1FromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignPlim1FromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignPlim1FromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Plim10 validation for a GovCT2
   *
   * @param command AssignPlim10ToGovCT2Command
   */
  public void validate(AssignPlim10ToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignPlim10ToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignPlim10ToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPlim10ToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Plim10 validation for a GovCT2
   *
   * @param command UnAssignPlim10FromGovCT2Command
   */
  public void validate(UnAssignPlim10FromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignPlim10FromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignPlim10FromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Plim2 validation for a GovCT2
   *
   * @param command AssignPlim2ToGovCT2Command
   */
  public void validate(AssignPlim2ToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignPlim2ToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignPlim2ToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPlim2ToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Plim2 validation for a GovCT2
   *
   * @param command UnAssignPlim2FromGovCT2Command
   */
  public void validate(UnAssignPlim2FromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignPlim2FromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignPlim2FromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Plim3 validation for a GovCT2
   *
   * @param command AssignPlim3ToGovCT2Command
   */
  public void validate(AssignPlim3ToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignPlim3ToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignPlim3ToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPlim3ToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Plim3 validation for a GovCT2
   *
   * @param command UnAssignPlim3FromGovCT2Command
   */
  public void validate(UnAssignPlim3FromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignPlim3FromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignPlim3FromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Plim4 validation for a GovCT2
   *
   * @param command AssignPlim4ToGovCT2Command
   */
  public void validate(AssignPlim4ToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignPlim4ToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignPlim4ToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPlim4ToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Plim4 validation for a GovCT2
   *
   * @param command UnAssignPlim4FromGovCT2Command
   */
  public void validate(UnAssignPlim4FromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignPlim4FromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignPlim4FromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Plim5 validation for a GovCT2
   *
   * @param command AssignPlim5ToGovCT2Command
   */
  public void validate(AssignPlim5ToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignPlim5ToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignPlim5ToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPlim5ToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Plim5 validation for a GovCT2
   *
   * @param command UnAssignPlim5FromGovCT2Command
   */
  public void validate(UnAssignPlim5FromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignPlim5FromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignPlim5FromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Plim6 validation for a GovCT2
   *
   * @param command AssignPlim6ToGovCT2Command
   */
  public void validate(AssignPlim6ToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignPlim6ToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignPlim6ToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPlim6ToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Plim6 validation for a GovCT2
   *
   * @param command UnAssignPlim6FromGovCT2Command
   */
  public void validate(UnAssignPlim6FromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignPlim6FromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignPlim6FromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Plim7 validation for a GovCT2
   *
   * @param command AssignPlim7ToGovCT2Command
   */
  public void validate(AssignPlim7ToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignPlim7ToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignPlim7ToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPlim7ToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Plim7 validation for a GovCT2
   *
   * @param command UnAssignPlim7FromGovCT2Command
   */
  public void validate(UnAssignPlim7FromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignPlim7FromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignPlim7FromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Plim8 validation for a GovCT2
   *
   * @param command AssignPlim8ToGovCT2Command
   */
  public void validate(AssignPlim8ToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignPlim8ToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignPlim8ToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPlim8ToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Plim8 validation for a GovCT2
   *
   * @param command UnAssignPlim8FromGovCT2Command
   */
  public void validate(UnAssignPlim8FromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignPlim8FromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignPlim8FromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Plim9 validation for a GovCT2
   *
   * @param command AssignPlim9ToGovCT2Command
   */
  public void validate(AssignPlim9ToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignPlim9ToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignPlim9ToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPlim9ToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Plim9 validation for a GovCT2
   *
   * @param command UnAssignPlim9FromGovCT2Command
   */
  public void validate(UnAssignPlim9FromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignPlim9FromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignPlim9FromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Prate validation for a GovCT2
   *
   * @param command AssignPrateToGovCT2Command
   */
  public void validate(AssignPrateToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignPrateToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignPrateToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPrateToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Prate validation for a GovCT2
   *
   * @param command UnAssignPrateFromGovCT2Command
   */
  public void validate(UnAssignPrateFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignPrateFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignPrateFromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign R validation for a GovCT2
   *
   * @param command AssignRToGovCT2Command
   */
  public void validate(AssignRToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignRToGovCT2Command should not be null");
    Assert.notNull(command.getGovCT2Id(), "AssignRToGovCT2Command identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignRToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign R validation for a GovCT2
   *
   * @param command UnAssignRFromGovCT2Command
   */
  public void validate(UnAssignRFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignRFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignRFromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Rclose validation for a GovCT2
   *
   * @param command AssignRcloseToGovCT2Command
   */
  public void validate(AssignRcloseToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignRcloseToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignRcloseToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRcloseToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Rclose validation for a GovCT2
   *
   * @param command UnAssignRcloseFromGovCT2Command
   */
  public void validate(UnAssignRcloseFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignRcloseFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignRcloseFromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Rdown validation for a GovCT2
   *
   * @param command AssignRdownToGovCT2Command
   */
  public void validate(AssignRdownToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignRdownToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignRdownToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRdownToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Rdown validation for a GovCT2
   *
   * @param command UnAssignRdownFromGovCT2Command
   */
  public void validate(UnAssignRdownFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignRdownFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignRdownFromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Ropen validation for a GovCT2
   *
   * @param command AssignRopenToGovCT2Command
   */
  public void validate(AssignRopenToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignRopenToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignRopenToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRopenToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Ropen validation for a GovCT2
   *
   * @param command UnAssignRopenFromGovCT2Command
   */
  public void validate(UnAssignRopenFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignRopenFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignRopenFromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Rup validation for a GovCT2
   *
   * @param command AssignRupToGovCT2Command
   */
  public void validate(AssignRupToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignRupToGovCT2Command should not be null");
    Assert.notNull(command.getGovCT2Id(), "AssignRupToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRupToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Rup validation for a GovCT2
   *
   * @param command UnAssignRupFromGovCT2Command
   */
  public void validate(UnAssignRupFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignRupFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignRupFromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Ta validation for a GovCT2
   *
   * @param command AssignTaToGovCT2Command
   */
  public void validate(AssignTaToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignTaToGovCT2Command should not be null");
    Assert.notNull(command.getGovCT2Id(), "AssignTaToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a GovCT2
   *
   * @param command UnAssignTaFromGovCT2Command
   */
  public void validate(UnAssignTaFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignTaFromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Tact validation for a GovCT2
   *
   * @param command AssignTactToGovCT2Command
   */
  public void validate(AssignTactToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignTactToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignTactToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTactToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Tact validation for a GovCT2
   *
   * @param command UnAssignTactFromGovCT2Command
   */
  public void validate(UnAssignTactFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTactFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignTactFromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Tb validation for a GovCT2
   *
   * @param command AssignTbToGovCT2Command
   */
  public void validate(AssignTbToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignTbToGovCT2Command should not be null");
    Assert.notNull(command.getGovCT2Id(), "AssignTbToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a GovCT2
   *
   * @param command UnAssignTbFromGovCT2Command
   */
  public void validate(UnAssignTbFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignTbFromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Tc validation for a GovCT2
   *
   * @param command AssignTcToGovCT2Command
   */
  public void validate(AssignTcToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignTcToGovCT2Command should not be null");
    Assert.notNull(command.getGovCT2Id(), "AssignTcToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a GovCT2
   *
   * @param command UnAssignTcFromGovCT2Command
   */
  public void validate(UnAssignTcFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignTcFromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Tdgov validation for a GovCT2
   *
   * @param command AssignTdgovToGovCT2Command
   */
  public void validate(AssignTdgovToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignTdgovToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignTdgovToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTdgovToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Tdgov validation for a GovCT2
   *
   * @param command UnAssignTdgovFromGovCT2Command
   */
  public void validate(UnAssignTdgovFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTdgovFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignTdgovFromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Teng validation for a GovCT2
   *
   * @param command AssignTengToGovCT2Command
   */
  public void validate(AssignTengToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignTengToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignTengToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTengToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Teng validation for a GovCT2
   *
   * @param command UnAssignTengFromGovCT2Command
   */
  public void validate(UnAssignTengFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTengFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignTengFromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Tfload validation for a GovCT2
   *
   * @param command AssignTfloadToGovCT2Command
   */
  public void validate(AssignTfloadToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignTfloadToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignTfloadToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfloadToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Tfload validation for a GovCT2
   *
   * @param command UnAssignTfloadFromGovCT2Command
   */
  public void validate(UnAssignTfloadFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTfloadFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignTfloadFromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Tpelec validation for a GovCT2
   *
   * @param command AssignTpelecToGovCT2Command
   */
  public void validate(AssignTpelecToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignTpelecToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignTpelecToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTpelecToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Tpelec validation for a GovCT2
   *
   * @param command UnAssignTpelecFromGovCT2Command
   */
  public void validate(UnAssignTpelecFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTpelecFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignTpelecFromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Tsa validation for a GovCT2
   *
   * @param command AssignTsaToGovCT2Command
   */
  public void validate(AssignTsaToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignTsaToGovCT2Command should not be null");
    Assert.notNull(command.getGovCT2Id(), "AssignTsaToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTsaToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Tsa validation for a GovCT2
   *
   * @param command UnAssignTsaFromGovCT2Command
   */
  public void validate(UnAssignTsaFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTsaFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignTsaFromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Tsb validation for a GovCT2
   *
   * @param command AssignTsbToGovCT2Command
   */
  public void validate(AssignTsbToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignTsbToGovCT2Command should not be null");
    Assert.notNull(command.getGovCT2Id(), "AssignTsbToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTsbToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Tsb validation for a GovCT2
   *
   * @param command UnAssignTsbFromGovCT2Command
   */
  public void validate(UnAssignTsbFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTsbFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignTsbFromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Vmax validation for a GovCT2
   *
   * @param command AssignVmaxToGovCT2Command
   */
  public void validate(AssignVmaxToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignVmaxToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignVmaxToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVmaxToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Vmax validation for a GovCT2
   *
   * @param command UnAssignVmaxFromGovCT2Command
   */
  public void validate(UnAssignVmaxFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignVmaxFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignVmaxFromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Vmin validation for a GovCT2
   *
   * @param command AssignVminToGovCT2Command
   */
  public void validate(AssignVminToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignVminToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignVminToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVminToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Vmin validation for a GovCT2
   *
   * @param command UnAssignVminFromGovCT2Command
   */
  public void validate(UnAssignVminFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignVminFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignVminFromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Wfnl validation for a GovCT2
   *
   * @param command AssignWfnlToGovCT2Command
   */
  public void validate(AssignWfnlToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignWfnlToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignWfnlToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignWfnlToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Wfnl validation for a GovCT2
   *
   * @param command UnAssignWfnlFromGovCT2Command
   */
  public void validate(UnAssignWfnlFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignWfnlFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignWfnlFromGovCT2Command identifier should not be null");
  }
  /**
   * handles assign Wfspd validation for a GovCT2
   *
   * @param command AssignWfspdToGovCT2Command
   */
  public void validate(AssignWfspdToGovCT2Command command) throws Exception {
    Assert.notNull(command, "AssignWfspdToGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "AssignWfspdToGovCT2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignWfspdToGovCT2Command assignment should not be null");
  }

  /**
   * handles unassign Wfspd validation for a GovCT2
   *
   * @param command UnAssignWfspdFromGovCT2Command
   */
  public void validate(UnAssignWfspdFromGovCT2Command command) throws Exception {
    Assert.notNull(command, "UnAssignWfspdFromGovCT2Command should not be null");
    Assert.notNull(
        command.getGovCT2Id(), "UnAssignWfspdFromGovCT2Command identifier should not be null");
  }
}
