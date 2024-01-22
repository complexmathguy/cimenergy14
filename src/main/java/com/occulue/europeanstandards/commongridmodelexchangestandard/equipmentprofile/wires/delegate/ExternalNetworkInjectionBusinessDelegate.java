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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.validator.*;
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
 * ExternalNetworkInjection business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of ExternalNetworkInjection related services in the case of a
 *       ExternalNetworkInjection business related service failing.
 *   <li>Exposes a simpler, uniform ExternalNetworkInjection interface to the business tier, making
 *       it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill ExternalNetworkInjection
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class ExternalNetworkInjectionBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public ExternalNetworkInjectionBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * ExternalNetworkInjection Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return ExternalNetworkInjectionBusinessDelegate
   */
  public static ExternalNetworkInjectionBusinessDelegate getExternalNetworkInjectionInstance() {
    return (new ExternalNetworkInjectionBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createExternalNetworkInjection(
      CreateExternalNetworkInjectionCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getExternalNetworkInjectionId() == null)
        command.setExternalNetworkInjectionId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExternalNetworkInjectionValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateExternalNetworkInjectionCommand - by convention the future return value for
      // a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateExternalNetworkInjectionCommand of ExternalNetworkInjection is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create ExternalNetworkInjection - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateExternalNetworkInjectionCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateExternalNetworkInjection(
      UpdateExternalNetworkInjectionCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      ExternalNetworkInjectionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateExternalNetworkInjectionCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save ExternalNetworkInjection - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteExternalNetworkInjectionCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteExternalNetworkInjectionCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExternalNetworkInjectionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteExternalNetworkInjectionCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete ExternalNetworkInjection using Id = "
              + command.getExternalNetworkInjectionId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the ExternalNetworkInjection via ExternalNetworkInjectionFetchOneSummary
   *
   * @param summary ExternalNetworkInjectionFetchOneSummary
   * @return ExternalNetworkInjectionFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public ExternalNetworkInjection getExternalNetworkInjection(
      ExternalNetworkInjectionFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "ExternalNetworkInjectionFetchOneSummary arg cannot be null");

    ExternalNetworkInjection entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      ExternalNetworkInjectionValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a ExternalNetworkInjection
      // --------------------------------------
      CompletableFuture<ExternalNetworkInjection> futureEntity =
          queryGateway.query(
              new FindExternalNetworkInjectionQuery(
                  new LoadExternalNetworkInjectionFilter(summary.getExternalNetworkInjectionId())),
              ResponseTypes.instanceOf(ExternalNetworkInjection.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate ExternalNetworkInjection with id "
              + summary.getExternalNetworkInjectionId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all ExternalNetworkInjections
   *
   * @return List<ExternalNetworkInjection>
   * @exception ProcessingException Thrown if any problems
   */
  public List<ExternalNetworkInjection> getAllExternalNetworkInjection()
      throws ProcessingException {
    List<ExternalNetworkInjection> list = null;

    try {
      CompletableFuture<List<ExternalNetworkInjection>> futureList =
          queryGateway.query(
              new FindAllExternalNetworkInjectionQuery(),
              ResponseTypes.multipleInstancesOf(ExternalNetworkInjection.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all ExternalNetworkInjection";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign GovernorSCD on ExternalNetworkInjection
   *
   * @param command AssignGovernorSCDToExternalNetworkInjectionCommand
   * @exception ProcessingException
   */
  public void assignGovernorSCD(AssignGovernorSCDToExternalNetworkInjectionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExternalNetworkInjectionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ActivePowerPerFrequencyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ActivePowerPerFrequencyBusinessDelegate.getActivePowerPerFrequencyInstance();
    ExternalNetworkInjectionBusinessDelegate parentDelegate =
        ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance();
    UUID childId = command.getAssignment().getActivePowerPerFrequencyId();
    ActivePowerPerFrequency child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExternalNetworkInjectionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get ActivePowerPerFrequency using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign GovernorSCD on ExternalNetworkInjection
   *
   * @param command UnAssignGovernorSCDFromExternalNetworkInjectionCommand
   * @exception ProcessingException
   */
  public void unAssignGovernorSCD(UnAssignGovernorSCDFromExternalNetworkInjectionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExternalNetworkInjectionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign GovernorSCD on ExternalNetworkInjection";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign IkSecond on ExternalNetworkInjection
   *
   * @param command AssignIkSecondToExternalNetworkInjectionCommand
   * @exception ProcessingException
   */
  public void assignIkSecond(AssignIkSecondToExternalNetworkInjectionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExternalNetworkInjectionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    ExternalNetworkInjectionBusinessDelegate parentDelegate =
        ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExternalNetworkInjectionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get BooleanProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign IkSecond on ExternalNetworkInjection
   *
   * @param command UnAssignIkSecondFromExternalNetworkInjectionCommand
   * @exception ProcessingException
   */
  public void unAssignIkSecond(UnAssignIkSecondFromExternalNetworkInjectionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExternalNetworkInjectionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign IkSecond on ExternalNetworkInjection";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign MaxInitialSymShCCurrent on ExternalNetworkInjection
   *
   * @param command AssignMaxInitialSymShCCurrentToExternalNetworkInjectionCommand
   * @exception ProcessingException
   */
  public void assignMaxInitialSymShCCurrent(
      AssignMaxInitialSymShCCurrentToExternalNetworkInjectionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExternalNetworkInjectionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .CurrentFlowBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .CurrentFlowBusinessDelegate.getCurrentFlowInstance();
    ExternalNetworkInjectionBusinessDelegate parentDelegate =
        ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance();
    UUID childId = command.getAssignment().getCurrentFlowId();
    CurrentFlow child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExternalNetworkInjectionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get CurrentFlow using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign MaxInitialSymShCCurrent on ExternalNetworkInjection
   *
   * @param command UnAssignMaxInitialSymShCCurrentFromExternalNetworkInjectionCommand
   * @exception ProcessingException
   */
  public void unAssignMaxInitialSymShCCurrent(
      UnAssignMaxInitialSymShCCurrentFromExternalNetworkInjectionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExternalNetworkInjectionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign MaxInitialSymShCCurrent on ExternalNetworkInjection";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign MaxP on ExternalNetworkInjection
   *
   * @param command AssignMaxPToExternalNetworkInjectionCommand
   * @exception ProcessingException
   */
  public void assignMaxP(AssignMaxPToExternalNetworkInjectionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExternalNetworkInjectionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ActivePowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ActivePowerBusinessDelegate.getActivePowerInstance();
    ExternalNetworkInjectionBusinessDelegate parentDelegate =
        ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance();
    UUID childId = command.getAssignment().getActivePowerId();
    ActivePower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExternalNetworkInjectionValidator.getInstance().validate(command);

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
   * unAssign MaxP on ExternalNetworkInjection
   *
   * @param command UnAssignMaxPFromExternalNetworkInjectionCommand
   * @exception ProcessingException
   */
  public void unAssignMaxP(UnAssignMaxPFromExternalNetworkInjectionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExternalNetworkInjectionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign MaxP on ExternalNetworkInjection";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign MaxQ on ExternalNetworkInjection
   *
   * @param command AssignMaxQToExternalNetworkInjectionCommand
   * @exception ProcessingException
   */
  public void assignMaxQ(AssignMaxQToExternalNetworkInjectionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExternalNetworkInjectionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ReactivePowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ReactivePowerBusinessDelegate.getReactivePowerInstance();
    ExternalNetworkInjectionBusinessDelegate parentDelegate =
        ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance();
    UUID childId = command.getAssignment().getReactivePowerId();
    ReactivePower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExternalNetworkInjectionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get ReactivePower using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign MaxQ on ExternalNetworkInjection
   *
   * @param command UnAssignMaxQFromExternalNetworkInjectionCommand
   * @exception ProcessingException
   */
  public void unAssignMaxQ(UnAssignMaxQFromExternalNetworkInjectionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExternalNetworkInjectionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign MaxQ on ExternalNetworkInjection";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign MaxR0ToX0Ratio on ExternalNetworkInjection
   *
   * @param command AssignMaxR0ToX0RatioToExternalNetworkInjectionCommand
   * @exception ProcessingException
   */
  public void assignMaxR0ToX0Ratio(AssignMaxR0ToX0RatioToExternalNetworkInjectionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExternalNetworkInjectionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    ExternalNetworkInjectionBusinessDelegate parentDelegate =
        ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExternalNetworkInjectionValidator.getInstance().validate(command);

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
   * unAssign MaxR0ToX0Ratio on ExternalNetworkInjection
   *
   * @param command UnAssignMaxR0ToX0RatioFromExternalNetworkInjectionCommand
   * @exception ProcessingException
   */
  public void unAssignMaxR0ToX0Ratio(
      UnAssignMaxR0ToX0RatioFromExternalNetworkInjectionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExternalNetworkInjectionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign MaxR0ToX0Ratio on ExternalNetworkInjection";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign MaxR1ToX1Ratio on ExternalNetworkInjection
   *
   * @param command AssignMaxR1ToX1RatioToExternalNetworkInjectionCommand
   * @exception ProcessingException
   */
  public void assignMaxR1ToX1Ratio(AssignMaxR1ToX1RatioToExternalNetworkInjectionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExternalNetworkInjectionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    ExternalNetworkInjectionBusinessDelegate parentDelegate =
        ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExternalNetworkInjectionValidator.getInstance().validate(command);

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
   * unAssign MaxR1ToX1Ratio on ExternalNetworkInjection
   *
   * @param command UnAssignMaxR1ToX1RatioFromExternalNetworkInjectionCommand
   * @exception ProcessingException
   */
  public void unAssignMaxR1ToX1Ratio(
      UnAssignMaxR1ToX1RatioFromExternalNetworkInjectionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExternalNetworkInjectionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign MaxR1ToX1Ratio on ExternalNetworkInjection";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign MaxZ0ToZ1Ratio on ExternalNetworkInjection
   *
   * @param command AssignMaxZ0ToZ1RatioToExternalNetworkInjectionCommand
   * @exception ProcessingException
   */
  public void assignMaxZ0ToZ1Ratio(AssignMaxZ0ToZ1RatioToExternalNetworkInjectionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExternalNetworkInjectionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    ExternalNetworkInjectionBusinessDelegate parentDelegate =
        ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExternalNetworkInjectionValidator.getInstance().validate(command);

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
   * unAssign MaxZ0ToZ1Ratio on ExternalNetworkInjection
   *
   * @param command UnAssignMaxZ0ToZ1RatioFromExternalNetworkInjectionCommand
   * @exception ProcessingException
   */
  public void unAssignMaxZ0ToZ1Ratio(
      UnAssignMaxZ0ToZ1RatioFromExternalNetworkInjectionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExternalNetworkInjectionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign MaxZ0ToZ1Ratio on ExternalNetworkInjection";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign MinInitialSymShCCurrent on ExternalNetworkInjection
   *
   * @param command AssignMinInitialSymShCCurrentToExternalNetworkInjectionCommand
   * @exception ProcessingException
   */
  public void assignMinInitialSymShCCurrent(
      AssignMinInitialSymShCCurrentToExternalNetworkInjectionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExternalNetworkInjectionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .CurrentFlowBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .CurrentFlowBusinessDelegate.getCurrentFlowInstance();
    ExternalNetworkInjectionBusinessDelegate parentDelegate =
        ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance();
    UUID childId = command.getAssignment().getCurrentFlowId();
    CurrentFlow child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExternalNetworkInjectionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get CurrentFlow using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign MinInitialSymShCCurrent on ExternalNetworkInjection
   *
   * @param command UnAssignMinInitialSymShCCurrentFromExternalNetworkInjectionCommand
   * @exception ProcessingException
   */
  public void unAssignMinInitialSymShCCurrent(
      UnAssignMinInitialSymShCCurrentFromExternalNetworkInjectionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExternalNetworkInjectionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign MinInitialSymShCCurrent on ExternalNetworkInjection";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign MinP on ExternalNetworkInjection
   *
   * @param command AssignMinPToExternalNetworkInjectionCommand
   * @exception ProcessingException
   */
  public void assignMinP(AssignMinPToExternalNetworkInjectionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExternalNetworkInjectionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ActivePowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ActivePowerBusinessDelegate.getActivePowerInstance();
    ExternalNetworkInjectionBusinessDelegate parentDelegate =
        ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance();
    UUID childId = command.getAssignment().getActivePowerId();
    ActivePower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExternalNetworkInjectionValidator.getInstance().validate(command);

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
   * unAssign MinP on ExternalNetworkInjection
   *
   * @param command UnAssignMinPFromExternalNetworkInjectionCommand
   * @exception ProcessingException
   */
  public void unAssignMinP(UnAssignMinPFromExternalNetworkInjectionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExternalNetworkInjectionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign MinP on ExternalNetworkInjection";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign MinQ on ExternalNetworkInjection
   *
   * @param command AssignMinQToExternalNetworkInjectionCommand
   * @exception ProcessingException
   */
  public void assignMinQ(AssignMinQToExternalNetworkInjectionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExternalNetworkInjectionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ReactivePowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ReactivePowerBusinessDelegate.getReactivePowerInstance();
    ExternalNetworkInjectionBusinessDelegate parentDelegate =
        ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance();
    UUID childId = command.getAssignment().getReactivePowerId();
    ReactivePower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExternalNetworkInjectionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get ReactivePower using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign MinQ on ExternalNetworkInjection
   *
   * @param command UnAssignMinQFromExternalNetworkInjectionCommand
   * @exception ProcessingException
   */
  public void unAssignMinQ(UnAssignMinQFromExternalNetworkInjectionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExternalNetworkInjectionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign MinQ on ExternalNetworkInjection";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign MinR0ToX0Ratio on ExternalNetworkInjection
   *
   * @param command AssignMinR0ToX0RatioToExternalNetworkInjectionCommand
   * @exception ProcessingException
   */
  public void assignMinR0ToX0Ratio(AssignMinR0ToX0RatioToExternalNetworkInjectionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExternalNetworkInjectionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    ExternalNetworkInjectionBusinessDelegate parentDelegate =
        ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExternalNetworkInjectionValidator.getInstance().validate(command);

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
   * unAssign MinR0ToX0Ratio on ExternalNetworkInjection
   *
   * @param command UnAssignMinR0ToX0RatioFromExternalNetworkInjectionCommand
   * @exception ProcessingException
   */
  public void unAssignMinR0ToX0Ratio(
      UnAssignMinR0ToX0RatioFromExternalNetworkInjectionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExternalNetworkInjectionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign MinR0ToX0Ratio on ExternalNetworkInjection";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign MinR1ToX1Ratio on ExternalNetworkInjection
   *
   * @param command AssignMinR1ToX1RatioToExternalNetworkInjectionCommand
   * @exception ProcessingException
   */
  public void assignMinR1ToX1Ratio(AssignMinR1ToX1RatioToExternalNetworkInjectionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExternalNetworkInjectionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    ExternalNetworkInjectionBusinessDelegate parentDelegate =
        ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExternalNetworkInjectionValidator.getInstance().validate(command);

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
   * unAssign MinR1ToX1Ratio on ExternalNetworkInjection
   *
   * @param command UnAssignMinR1ToX1RatioFromExternalNetworkInjectionCommand
   * @exception ProcessingException
   */
  public void unAssignMinR1ToX1Ratio(
      UnAssignMinR1ToX1RatioFromExternalNetworkInjectionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExternalNetworkInjectionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign MinR1ToX1Ratio on ExternalNetworkInjection";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign MinZ0ToZ1Ratio on ExternalNetworkInjection
   *
   * @param command AssignMinZ0ToZ1RatioToExternalNetworkInjectionCommand
   * @exception ProcessingException
   */
  public void assignMinZ0ToZ1Ratio(AssignMinZ0ToZ1RatioToExternalNetworkInjectionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExternalNetworkInjectionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    ExternalNetworkInjectionBusinessDelegate parentDelegate =
        ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExternalNetworkInjectionValidator.getInstance().validate(command);

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
   * unAssign MinZ0ToZ1Ratio on ExternalNetworkInjection
   *
   * @param command UnAssignMinZ0ToZ1RatioFromExternalNetworkInjectionCommand
   * @exception ProcessingException
   */
  public void unAssignMinZ0ToZ1Ratio(
      UnAssignMinZ0ToZ1RatioFromExternalNetworkInjectionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExternalNetworkInjectionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign MinZ0ToZ1Ratio on ExternalNetworkInjection";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign VoltageFactor on ExternalNetworkInjection
   *
   * @param command AssignVoltageFactorToExternalNetworkInjectionCommand
   * @exception ProcessingException
   */
  public void assignVoltageFactor(AssignVoltageFactorToExternalNetworkInjectionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExternalNetworkInjectionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExternalNetworkInjectionBusinessDelegate parentDelegate =
        ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExternalNetworkInjectionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PU using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign VoltageFactor on ExternalNetworkInjection
   *
   * @param command UnAssignVoltageFactorFromExternalNetworkInjectionCommand
   * @exception ProcessingException
   */
  public void unAssignVoltageFactor(
      UnAssignVoltageFactorFromExternalNetworkInjectionCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExternalNetworkInjectionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign VoltageFactor on ExternalNetworkInjection";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return ExternalNetworkInjection
   */
  private ExternalNetworkInjection load(UUID id) throws ProcessingException {
    externalNetworkInjection =
        ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
            .getExternalNetworkInjection(new ExternalNetworkInjectionFetchOneSummary(id));
    return externalNetworkInjection;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private ExternalNetworkInjection externalNetworkInjection = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExternalNetworkInjectionBusinessDelegate.class.getName());
}
