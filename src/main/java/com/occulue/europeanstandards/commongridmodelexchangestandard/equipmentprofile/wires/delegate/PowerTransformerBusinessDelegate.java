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
 * PowerTransformer business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of PowerTransformer related services in the case of a
 *       PowerTransformer business related service failing.
 *   <li>Exposes a simpler, uniform PowerTransformer interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill PowerTransformer business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class PowerTransformerBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public PowerTransformerBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * PowerTransformer Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return PowerTransformerBusinessDelegate
   */
  public static PowerTransformerBusinessDelegate getPowerTransformerInstance() {
    return (new PowerTransformerBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createPowerTransformer(CreatePowerTransformerCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getPowerTransformerId() == null) command.setPowerTransformerId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      PowerTransformerValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreatePowerTransformerCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreatePowerTransformerCommand of PowerTransformer is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create PowerTransformer - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdatePowerTransformerCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updatePowerTransformer(UpdatePowerTransformerCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      PowerTransformerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdatePowerTransformerCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save PowerTransformer - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeletePowerTransformerCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeletePowerTransformerCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PowerTransformerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeletePowerTransformerCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete PowerTransformer using Id = " + command.getPowerTransformerId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the PowerTransformer via PowerTransformerFetchOneSummary
   *
   * @param summary PowerTransformerFetchOneSummary
   * @return PowerTransformerFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public PowerTransformer getPowerTransformer(PowerTransformerFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("PowerTransformerFetchOneSummary arg cannot be null");

    PowerTransformer entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      PowerTransformerValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a PowerTransformer
      // --------------------------------------
      CompletableFuture<PowerTransformer> futureEntity =
          queryGateway.query(
              new FindPowerTransformerQuery(
                  new LoadPowerTransformerFilter(summary.getPowerTransformerId())),
              ResponseTypes.instanceOf(PowerTransformer.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate PowerTransformer with id " + summary.getPowerTransformerId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all PowerTransformers
   *
   * @return List<PowerTransformer>
   * @exception ProcessingException Thrown if any problems
   */
  public List<PowerTransformer> getAllPowerTransformer() throws ProcessingException {
    List<PowerTransformer> list = null;

    try {
      CompletableFuture<List<PowerTransformer>> futureList =
          queryGateway.query(
              new FindAllPowerTransformerQuery(),
              ResponseTypes.multipleInstancesOf(PowerTransformer.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all PowerTransformer";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign BeforeShCircuitHighestOperatingCurrent on PowerTransformer
   *
   * @param command AssignBeforeShCircuitHighestOperatingCurrentToPowerTransformerCommand
   * @exception ProcessingException
   */
  public void assignBeforeShCircuitHighestOperatingCurrent(
      AssignBeforeShCircuitHighestOperatingCurrentToPowerTransformerCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPowerTransformerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .CurrentFlowBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .CurrentFlowBusinessDelegate.getCurrentFlowInstance();
    PowerTransformerBusinessDelegate parentDelegate =
        PowerTransformerBusinessDelegate.getPowerTransformerInstance();
    UUID childId = command.getAssignment().getCurrentFlowId();
    CurrentFlow child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PowerTransformerValidator.getInstance().validate(command);

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
   * unAssign BeforeShCircuitHighestOperatingCurrent on PowerTransformer
   *
   * @param command UnAssignBeforeShCircuitHighestOperatingCurrentFromPowerTransformerCommand
   * @exception ProcessingException
   */
  public void unAssignBeforeShCircuitHighestOperatingCurrent(
      UnAssignBeforeShCircuitHighestOperatingCurrentFromPowerTransformerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PowerTransformerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg =
          "Failed to unassign BeforeShCircuitHighestOperatingCurrent on PowerTransformer";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign BeforeShCircuitHighestOperatingVoltage on PowerTransformer
   *
   * @param command AssignBeforeShCircuitHighestOperatingVoltageToPowerTransformerCommand
   * @exception ProcessingException
   */
  public void assignBeforeShCircuitHighestOperatingVoltage(
      AssignBeforeShCircuitHighestOperatingVoltageToPowerTransformerCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPowerTransformerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .VoltageBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .VoltageBusinessDelegate.getVoltageInstance();
    PowerTransformerBusinessDelegate parentDelegate =
        PowerTransformerBusinessDelegate.getPowerTransformerInstance();
    UUID childId = command.getAssignment().getVoltageId();
    Voltage child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PowerTransformerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Voltage using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign BeforeShCircuitHighestOperatingVoltage on PowerTransformer
   *
   * @param command UnAssignBeforeShCircuitHighestOperatingVoltageFromPowerTransformerCommand
   * @exception ProcessingException
   */
  public void unAssignBeforeShCircuitHighestOperatingVoltage(
      UnAssignBeforeShCircuitHighestOperatingVoltageFromPowerTransformerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PowerTransformerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg =
          "Failed to unassign BeforeShCircuitHighestOperatingVoltage on PowerTransformer";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign BeforeShortCircuitAnglePf on PowerTransformer
   *
   * @param command AssignBeforeShortCircuitAnglePfToPowerTransformerCommand
   * @exception ProcessingException
   */
  public void assignBeforeShortCircuitAnglePf(
      AssignBeforeShortCircuitAnglePfToPowerTransformerCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPowerTransformerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .AngleDegreesBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .AngleDegreesBusinessDelegate.getAngleDegreesInstance();
    PowerTransformerBusinessDelegate parentDelegate =
        PowerTransformerBusinessDelegate.getPowerTransformerInstance();
    UUID childId = command.getAssignment().getAngleDegreesId();
    AngleDegrees child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PowerTransformerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get AngleDegrees using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign BeforeShortCircuitAnglePf on PowerTransformer
   *
   * @param command UnAssignBeforeShortCircuitAnglePfFromPowerTransformerCommand
   * @exception ProcessingException
   */
  public void unAssignBeforeShortCircuitAnglePf(
      UnAssignBeforeShortCircuitAnglePfFromPowerTransformerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PowerTransformerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign BeforeShortCircuitAnglePf on PowerTransformer";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign HighSideMinOperatingU on PowerTransformer
   *
   * @param command AssignHighSideMinOperatingUToPowerTransformerCommand
   * @exception ProcessingException
   */
  public void assignHighSideMinOperatingU(
      AssignHighSideMinOperatingUToPowerTransformerCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPowerTransformerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .VoltageBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .VoltageBusinessDelegate.getVoltageInstance();
    PowerTransformerBusinessDelegate parentDelegate =
        PowerTransformerBusinessDelegate.getPowerTransformerInstance();
    UUID childId = command.getAssignment().getVoltageId();
    Voltage child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PowerTransformerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Voltage using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign HighSideMinOperatingU on PowerTransformer
   *
   * @param command UnAssignHighSideMinOperatingUFromPowerTransformerCommand
   * @exception ProcessingException
   */
  public void unAssignHighSideMinOperatingU(
      UnAssignHighSideMinOperatingUFromPowerTransformerCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PowerTransformerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign HighSideMinOperatingU on PowerTransformer";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign PartOfGeneratorUnitFlag on PowerTransformer
   *
   * @param command AssignPartOfGeneratorUnitFlagToPowerTransformerCommand
   * @exception ProcessingException
   */
  public void assignPartOfGeneratorUnitFlag(
      AssignPartOfGeneratorUnitFlagToPowerTransformerCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPowerTransformerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    PowerTransformerBusinessDelegate parentDelegate =
        PowerTransformerBusinessDelegate.getPowerTransformerInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PowerTransformerValidator.getInstance().validate(command);

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
   * unAssign PartOfGeneratorUnitFlag on PowerTransformer
   *
   * @param command UnAssignPartOfGeneratorUnitFlagFromPowerTransformerCommand
   * @exception ProcessingException
   */
  public void unAssignPartOfGeneratorUnitFlag(
      UnAssignPartOfGeneratorUnitFlagFromPowerTransformerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PowerTransformerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign PartOfGeneratorUnitFlag on PowerTransformer";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign OperationalValuesConsidered on PowerTransformer
   *
   * @param command AssignOperationalValuesConsideredToPowerTransformerCommand
   * @exception ProcessingException
   */
  public void assignOperationalValuesConsidered(
      AssignOperationalValuesConsideredToPowerTransformerCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPowerTransformerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    PowerTransformerBusinessDelegate parentDelegate =
        PowerTransformerBusinessDelegate.getPowerTransformerInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PowerTransformerValidator.getInstance().validate(command);

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
   * unAssign OperationalValuesConsidered on PowerTransformer
   *
   * @param command UnAssignOperationalValuesConsideredFromPowerTransformerCommand
   * @exception ProcessingException
   */
  public void unAssignOperationalValuesConsidered(
      UnAssignOperationalValuesConsideredFromPowerTransformerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PowerTransformerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign OperationalValuesConsidered on PowerTransformer";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return PowerTransformer
   */
  private PowerTransformer load(UUID id) throws ProcessingException {
    powerTransformer =
        PowerTransformerBusinessDelegate.getPowerTransformerInstance()
            .getPowerTransformer(new PowerTransformerFetchOneSummary(id));
    return powerTransformer;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private PowerTransformer powerTransformer = null;
  private static final Logger LOGGER =
      Logger.getLogger(PowerTransformerBusinessDelegate.class.getName());
}
