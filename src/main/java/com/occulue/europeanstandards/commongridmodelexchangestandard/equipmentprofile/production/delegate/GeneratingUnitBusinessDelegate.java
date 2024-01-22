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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.validator.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * GeneratingUnit business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of GeneratingUnit related services in the case of a GeneratingUnit
 *       business related service failing.
 *   <li>Exposes a simpler, uniform GeneratingUnit interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill GeneratingUnit business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class GeneratingUnitBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public GeneratingUnitBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * GeneratingUnit Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return GeneratingUnitBusinessDelegate
   */
  public static GeneratingUnitBusinessDelegate getGeneratingUnitInstance() {
    return (new GeneratingUnitBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createGeneratingUnit(CreateGeneratingUnitCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getGeneratingUnitId() == null) command.setGeneratingUnitId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      GeneratingUnitValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateGeneratingUnitCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateGeneratingUnitCommand of GeneratingUnit is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create GeneratingUnit - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateGeneratingUnitCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateGeneratingUnit(UpdateGeneratingUnitCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      GeneratingUnitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateGeneratingUnitCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save GeneratingUnit - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteGeneratingUnitCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteGeneratingUnitCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GeneratingUnitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteGeneratingUnitCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete GeneratingUnit using Id = " + command.getGeneratingUnitId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the GeneratingUnit via GeneratingUnitFetchOneSummary
   *
   * @param summary GeneratingUnitFetchOneSummary
   * @return GeneratingUnitFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public GeneratingUnit getGeneratingUnit(GeneratingUnitFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("GeneratingUnitFetchOneSummary arg cannot be null");

    GeneratingUnit entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      GeneratingUnitValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a GeneratingUnit
      // --------------------------------------
      CompletableFuture<GeneratingUnit> futureEntity =
          queryGateway.query(
              new FindGeneratingUnitQuery(
                  new LoadGeneratingUnitFilter(summary.getGeneratingUnitId())),
              ResponseTypes.instanceOf(GeneratingUnit.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate GeneratingUnit with id " + summary.getGeneratingUnitId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all GeneratingUnits
   *
   * @return List<GeneratingUnit>
   * @exception ProcessingException Thrown if any problems
   */
  public List<GeneratingUnit> getAllGeneratingUnit() throws ProcessingException {
    List<GeneratingUnit> list = null;

    try {
      CompletableFuture<List<GeneratingUnit>> futureList =
          queryGateway.query(
              new FindAllGeneratingUnitQuery(),
              ResponseTypes.multipleInstancesOf(GeneratingUnit.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all GeneratingUnit";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign GovernorSCD on GeneratingUnit
   *
   * @param command AssignGovernorSCDToGeneratingUnitCommand
   * @exception ProcessingException
   */
  public void assignGovernorSCD(AssignGovernorSCDToGeneratingUnitCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGeneratingUnitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PerCentBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PerCentBusinessDelegate.getPerCentInstance();
    GeneratingUnitBusinessDelegate parentDelegate =
        GeneratingUnitBusinessDelegate.getGeneratingUnitInstance();
    UUID childId = command.getAssignment().getPerCentId();
    PerCent child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GeneratingUnitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PerCent using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign GovernorSCD on GeneratingUnit
   *
   * @param command UnAssignGovernorSCDFromGeneratingUnitCommand
   * @exception ProcessingException
   */
  public void unAssignGovernorSCD(UnAssignGovernorSCDFromGeneratingUnitCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GeneratingUnitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign GovernorSCD on GeneratingUnit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign InitialP on GeneratingUnit
   *
   * @param command AssignInitialPToGeneratingUnitCommand
   * @exception ProcessingException
   */
  public void assignInitialP(AssignInitialPToGeneratingUnitCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGeneratingUnitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ActivePowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ActivePowerBusinessDelegate.getActivePowerInstance();
    GeneratingUnitBusinessDelegate parentDelegate =
        GeneratingUnitBusinessDelegate.getGeneratingUnitInstance();
    UUID childId = command.getAssignment().getActivePowerId();
    ActivePower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GeneratingUnitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get ActivePower using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign InitialP on GeneratingUnit
   *
   * @param command UnAssignInitialPFromGeneratingUnitCommand
   * @exception ProcessingException
   */
  public void unAssignInitialP(UnAssignInitialPFromGeneratingUnitCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GeneratingUnitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign InitialP on GeneratingUnit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign LongPF on GeneratingUnit
   *
   * @param command AssignLongPFToGeneratingUnitCommand
   * @exception ProcessingException
   */
  public void assignLongPF(AssignLongPFToGeneratingUnitCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGeneratingUnitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    GeneratingUnitBusinessDelegate parentDelegate =
        GeneratingUnitBusinessDelegate.getGeneratingUnitInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GeneratingUnitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Simple_Float using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign LongPF on GeneratingUnit
   *
   * @param command UnAssignLongPFFromGeneratingUnitCommand
   * @exception ProcessingException
   */
  public void unAssignLongPF(UnAssignLongPFFromGeneratingUnitCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GeneratingUnitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign LongPF on GeneratingUnit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign MaximumAllowableSpinningReserve on GeneratingUnit
   *
   * @param command AssignMaximumAllowableSpinningReserveToGeneratingUnitCommand
   * @exception ProcessingException
   */
  public void assignMaximumAllowableSpinningReserve(
      AssignMaximumAllowableSpinningReserveToGeneratingUnitCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGeneratingUnitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ActivePowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ActivePowerBusinessDelegate.getActivePowerInstance();
    GeneratingUnitBusinessDelegate parentDelegate =
        GeneratingUnitBusinessDelegate.getGeneratingUnitInstance();
    UUID childId = command.getAssignment().getActivePowerId();
    ActivePower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GeneratingUnitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get ActivePower using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign MaximumAllowableSpinningReserve on GeneratingUnit
   *
   * @param command UnAssignMaximumAllowableSpinningReserveFromGeneratingUnitCommand
   * @exception ProcessingException
   */
  public void unAssignMaximumAllowableSpinningReserve(
      UnAssignMaximumAllowableSpinningReserveFromGeneratingUnitCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GeneratingUnitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign MaximumAllowableSpinningReserve on GeneratingUnit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign MaxOperatingP on GeneratingUnit
   *
   * @param command AssignMaxOperatingPToGeneratingUnitCommand
   * @exception ProcessingException
   */
  public void assignMaxOperatingP(AssignMaxOperatingPToGeneratingUnitCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGeneratingUnitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ActivePowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ActivePowerBusinessDelegate.getActivePowerInstance();
    GeneratingUnitBusinessDelegate parentDelegate =
        GeneratingUnitBusinessDelegate.getGeneratingUnitInstance();
    UUID childId = command.getAssignment().getActivePowerId();
    ActivePower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GeneratingUnitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get ActivePower using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign MaxOperatingP on GeneratingUnit
   *
   * @param command UnAssignMaxOperatingPFromGeneratingUnitCommand
   * @exception ProcessingException
   */
  public void unAssignMaxOperatingP(UnAssignMaxOperatingPFromGeneratingUnitCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GeneratingUnitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign MaxOperatingP on GeneratingUnit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign MinOperatingP on GeneratingUnit
   *
   * @param command AssignMinOperatingPToGeneratingUnitCommand
   * @exception ProcessingException
   */
  public void assignMinOperatingP(AssignMinOperatingPToGeneratingUnitCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGeneratingUnitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ActivePowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ActivePowerBusinessDelegate.getActivePowerInstance();
    GeneratingUnitBusinessDelegate parentDelegate =
        GeneratingUnitBusinessDelegate.getGeneratingUnitInstance();
    UUID childId = command.getAssignment().getActivePowerId();
    ActivePower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GeneratingUnitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get ActivePower using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign MinOperatingP on GeneratingUnit
   *
   * @param command UnAssignMinOperatingPFromGeneratingUnitCommand
   * @exception ProcessingException
   */
  public void unAssignMinOperatingP(UnAssignMinOperatingPFromGeneratingUnitCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GeneratingUnitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign MinOperatingP on GeneratingUnit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign NominalP on GeneratingUnit
   *
   * @param command AssignNominalPToGeneratingUnitCommand
   * @exception ProcessingException
   */
  public void assignNominalP(AssignNominalPToGeneratingUnitCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGeneratingUnitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ActivePowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ActivePowerBusinessDelegate.getActivePowerInstance();
    GeneratingUnitBusinessDelegate parentDelegate =
        GeneratingUnitBusinessDelegate.getGeneratingUnitInstance();
    UUID childId = command.getAssignment().getActivePowerId();
    ActivePower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GeneratingUnitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get ActivePower using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign NominalP on GeneratingUnit
   *
   * @param command UnAssignNominalPFromGeneratingUnitCommand
   * @exception ProcessingException
   */
  public void unAssignNominalP(UnAssignNominalPFromGeneratingUnitCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GeneratingUnitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign NominalP on GeneratingUnit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign RatedGrossMaxP on GeneratingUnit
   *
   * @param command AssignRatedGrossMaxPToGeneratingUnitCommand
   * @exception ProcessingException
   */
  public void assignRatedGrossMaxP(AssignRatedGrossMaxPToGeneratingUnitCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGeneratingUnitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ActivePowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ActivePowerBusinessDelegate.getActivePowerInstance();
    GeneratingUnitBusinessDelegate parentDelegate =
        GeneratingUnitBusinessDelegate.getGeneratingUnitInstance();
    UUID childId = command.getAssignment().getActivePowerId();
    ActivePower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GeneratingUnitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get ActivePower using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign RatedGrossMaxP on GeneratingUnit
   *
   * @param command UnAssignRatedGrossMaxPFromGeneratingUnitCommand
   * @exception ProcessingException
   */
  public void unAssignRatedGrossMaxP(UnAssignRatedGrossMaxPFromGeneratingUnitCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GeneratingUnitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign RatedGrossMaxP on GeneratingUnit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign RatedGrossMinP on GeneratingUnit
   *
   * @param command AssignRatedGrossMinPToGeneratingUnitCommand
   * @exception ProcessingException
   */
  public void assignRatedGrossMinP(AssignRatedGrossMinPToGeneratingUnitCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGeneratingUnitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ActivePowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ActivePowerBusinessDelegate.getActivePowerInstance();
    GeneratingUnitBusinessDelegate parentDelegate =
        GeneratingUnitBusinessDelegate.getGeneratingUnitInstance();
    UUID childId = command.getAssignment().getActivePowerId();
    ActivePower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GeneratingUnitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get ActivePower using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign RatedGrossMinP on GeneratingUnit
   *
   * @param command UnAssignRatedGrossMinPFromGeneratingUnitCommand
   * @exception ProcessingException
   */
  public void unAssignRatedGrossMinP(UnAssignRatedGrossMinPFromGeneratingUnitCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GeneratingUnitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign RatedGrossMinP on GeneratingUnit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign RatedNetMaxP on GeneratingUnit
   *
   * @param command AssignRatedNetMaxPToGeneratingUnitCommand
   * @exception ProcessingException
   */
  public void assignRatedNetMaxP(AssignRatedNetMaxPToGeneratingUnitCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGeneratingUnitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ActivePowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ActivePowerBusinessDelegate.getActivePowerInstance();
    GeneratingUnitBusinessDelegate parentDelegate =
        GeneratingUnitBusinessDelegate.getGeneratingUnitInstance();
    UUID childId = command.getAssignment().getActivePowerId();
    ActivePower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GeneratingUnitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get ActivePower using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign RatedNetMaxP on GeneratingUnit
   *
   * @param command UnAssignRatedNetMaxPFromGeneratingUnitCommand
   * @exception ProcessingException
   */
  public void unAssignRatedNetMaxP(UnAssignRatedNetMaxPFromGeneratingUnitCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GeneratingUnitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign RatedNetMaxP on GeneratingUnit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign ShortPF on GeneratingUnit
   *
   * @param command AssignShortPFToGeneratingUnitCommand
   * @exception ProcessingException
   */
  public void assignShortPF(AssignShortPFToGeneratingUnitCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGeneratingUnitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    GeneratingUnitBusinessDelegate parentDelegate =
        GeneratingUnitBusinessDelegate.getGeneratingUnitInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GeneratingUnitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Simple_Float using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign ShortPF on GeneratingUnit
   *
   * @param command UnAssignShortPFFromGeneratingUnitCommand
   * @exception ProcessingException
   */
  public void unAssignShortPF(UnAssignShortPFFromGeneratingUnitCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GeneratingUnitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ShortPF on GeneratingUnit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign StartupCost on GeneratingUnit
   *
   * @param command AssignStartupCostToGeneratingUnitCommand
   * @exception ProcessingException
   */
  public void assignStartupCost(AssignStartupCostToGeneratingUnitCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGeneratingUnitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .MoneyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .MoneyBusinessDelegate.getMoneyInstance();
    GeneratingUnitBusinessDelegate parentDelegate =
        GeneratingUnitBusinessDelegate.getGeneratingUnitInstance();
    UUID childId = command.getAssignment().getMoneyId();
    Money child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GeneratingUnitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Money using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign StartupCost on GeneratingUnit
   *
   * @param command UnAssignStartupCostFromGeneratingUnitCommand
   * @exception ProcessingException
   */
  public void unAssignStartupCost(UnAssignStartupCostFromGeneratingUnitCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GeneratingUnitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign StartupCost on GeneratingUnit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign TotalEfficiency on GeneratingUnit
   *
   * @param command AssignTotalEfficiencyToGeneratingUnitCommand
   * @exception ProcessingException
   */
  public void assignTotalEfficiency(AssignTotalEfficiencyToGeneratingUnitCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGeneratingUnitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PerCentBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PerCentBusinessDelegate.getPerCentInstance();
    GeneratingUnitBusinessDelegate parentDelegate =
        GeneratingUnitBusinessDelegate.getGeneratingUnitInstance();
    UUID childId = command.getAssignment().getPerCentId();
    PerCent child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GeneratingUnitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PerCent using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign TotalEfficiency on GeneratingUnit
   *
   * @param command UnAssignTotalEfficiencyFromGeneratingUnitCommand
   * @exception ProcessingException
   */
  public void unAssignTotalEfficiency(UnAssignTotalEfficiencyFromGeneratingUnitCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GeneratingUnitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign TotalEfficiency on GeneratingUnit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign VariableCost on GeneratingUnit
   *
   * @param command AssignVariableCostToGeneratingUnitCommand
   * @exception ProcessingException
   */
  public void assignVariableCost(AssignVariableCostToGeneratingUnitCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGeneratingUnitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .MoneyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .MoneyBusinessDelegate.getMoneyInstance();
    GeneratingUnitBusinessDelegate parentDelegate =
        GeneratingUnitBusinessDelegate.getGeneratingUnitInstance();
    UUID childId = command.getAssignment().getMoneyId();
    Money child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GeneratingUnitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Money using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign VariableCost on GeneratingUnit
   *
   * @param command UnAssignVariableCostFromGeneratingUnitCommand
   * @exception ProcessingException
   */
  public void unAssignVariableCost(UnAssignVariableCostFromGeneratingUnitCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GeneratingUnitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign VariableCost on GeneratingUnit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return GeneratingUnit
   */
  private GeneratingUnit load(UUID id) throws ProcessingException {
    generatingUnit =
        GeneratingUnitBusinessDelegate.getGeneratingUnitInstance()
            .getGeneratingUnit(new GeneratingUnitFetchOneSummary(id));
    return generatingUnit;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private GeneratingUnit generatingUnit = null;
  private static final Logger LOGGER =
      Logger.getLogger(GeneratingUnitBusinessDelegate.class.getName());
}
