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
 * StaticVarCompensator business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of StaticVarCompensator related services in the case of a
 *       StaticVarCompensator business related service failing.
 *   <li>Exposes a simpler, uniform StaticVarCompensator interface to the business tier, making it
 *       easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill StaticVarCompensator
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class StaticVarCompensatorBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public StaticVarCompensatorBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * StaticVarCompensator Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return StaticVarCompensatorBusinessDelegate
   */
  public static StaticVarCompensatorBusinessDelegate getStaticVarCompensatorInstance() {
    return (new StaticVarCompensatorBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createStaticVarCompensator(
      CreateStaticVarCompensatorCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getStaticVarCompensatorId() == null)
        command.setStaticVarCompensatorId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      StaticVarCompensatorValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateStaticVarCompensatorCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateStaticVarCompensatorCommand of StaticVarCompensator is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create StaticVarCompensator - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateStaticVarCompensatorCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateStaticVarCompensator(
      UpdateStaticVarCompensatorCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      StaticVarCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateStaticVarCompensatorCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save StaticVarCompensator - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteStaticVarCompensatorCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteStaticVarCompensatorCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      StaticVarCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteStaticVarCompensatorCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete StaticVarCompensator using Id = " + command.getStaticVarCompensatorId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the StaticVarCompensator via StaticVarCompensatorFetchOneSummary
   *
   * @param summary StaticVarCompensatorFetchOneSummary
   * @return StaticVarCompensatorFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public StaticVarCompensator getStaticVarCompensator(StaticVarCompensatorFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("StaticVarCompensatorFetchOneSummary arg cannot be null");

    StaticVarCompensator entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      StaticVarCompensatorValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a StaticVarCompensator
      // --------------------------------------
      CompletableFuture<StaticVarCompensator> futureEntity =
          queryGateway.query(
              new FindStaticVarCompensatorQuery(
                  new LoadStaticVarCompensatorFilter(summary.getStaticVarCompensatorId())),
              ResponseTypes.instanceOf(StaticVarCompensator.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate StaticVarCompensator with id " + summary.getStaticVarCompensatorId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all StaticVarCompensators
   *
   * @return List<StaticVarCompensator>
   * @exception ProcessingException Thrown if any problems
   */
  public List<StaticVarCompensator> getAllStaticVarCompensator() throws ProcessingException {
    List<StaticVarCompensator> list = null;

    try {
      CompletableFuture<List<StaticVarCompensator>> futureList =
          queryGateway.query(
              new FindAllStaticVarCompensatorQuery(),
              ResponseTypes.multipleInstancesOf(StaticVarCompensator.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all StaticVarCompensator";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign CapacitiveRating on StaticVarCompensator
   *
   * @param command AssignCapacitiveRatingToStaticVarCompensatorCommand
   * @exception ProcessingException
   */
  public void assignCapacitiveRating(AssignCapacitiveRatingToStaticVarCompensatorCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getStaticVarCompensatorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ReactanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ReactanceBusinessDelegate.getReactanceInstance();
    StaticVarCompensatorBusinessDelegate parentDelegate =
        StaticVarCompensatorBusinessDelegate.getStaticVarCompensatorInstance();
    UUID childId = command.getAssignment().getReactanceId();
    Reactance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      StaticVarCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Reactance using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign CapacitiveRating on StaticVarCompensator
   *
   * @param command UnAssignCapacitiveRatingFromStaticVarCompensatorCommand
   * @exception ProcessingException
   */
  public void unAssignCapacitiveRating(
      UnAssignCapacitiveRatingFromStaticVarCompensatorCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      StaticVarCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign CapacitiveRating on StaticVarCompensator";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign InductiveRating on StaticVarCompensator
   *
   * @param command AssignInductiveRatingToStaticVarCompensatorCommand
   * @exception ProcessingException
   */
  public void assignInductiveRating(AssignInductiveRatingToStaticVarCompensatorCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getStaticVarCompensatorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ReactanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ReactanceBusinessDelegate.getReactanceInstance();
    StaticVarCompensatorBusinessDelegate parentDelegate =
        StaticVarCompensatorBusinessDelegate.getStaticVarCompensatorInstance();
    UUID childId = command.getAssignment().getReactanceId();
    Reactance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      StaticVarCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Reactance using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign InductiveRating on StaticVarCompensator
   *
   * @param command UnAssignInductiveRatingFromStaticVarCompensatorCommand
   * @exception ProcessingException
   */
  public void unAssignInductiveRating(
      UnAssignInductiveRatingFromStaticVarCompensatorCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      StaticVarCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign InductiveRating on StaticVarCompensator";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Slope on StaticVarCompensator
   *
   * @param command AssignSlopeToStaticVarCompensatorCommand
   * @exception ProcessingException
   */
  public void assignSlope(AssignSlopeToStaticVarCompensatorCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getStaticVarCompensatorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .VoltagePerReactivePowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .VoltagePerReactivePowerBusinessDelegate.getVoltagePerReactivePowerInstance();
    StaticVarCompensatorBusinessDelegate parentDelegate =
        StaticVarCompensatorBusinessDelegate.getStaticVarCompensatorInstance();
    UUID childId = command.getAssignment().getVoltagePerReactivePowerId();
    VoltagePerReactivePower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      StaticVarCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get VoltagePerReactivePower using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Slope on StaticVarCompensator
   *
   * @param command UnAssignSlopeFromStaticVarCompensatorCommand
   * @exception ProcessingException
   */
  public void unAssignSlope(UnAssignSlopeFromStaticVarCompensatorCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      StaticVarCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Slope on StaticVarCompensator";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign VoltageSetPoint on StaticVarCompensator
   *
   * @param command AssignVoltageSetPointToStaticVarCompensatorCommand
   * @exception ProcessingException
   */
  public void assignVoltageSetPoint(AssignVoltageSetPointToStaticVarCompensatorCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getStaticVarCompensatorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .VoltageBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .VoltageBusinessDelegate.getVoltageInstance();
    StaticVarCompensatorBusinessDelegate parentDelegate =
        StaticVarCompensatorBusinessDelegate.getStaticVarCompensatorInstance();
    UUID childId = command.getAssignment().getVoltageId();
    Voltage child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      StaticVarCompensatorValidator.getInstance().validate(command);

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
   * unAssign VoltageSetPoint on StaticVarCompensator
   *
   * @param command UnAssignVoltageSetPointFromStaticVarCompensatorCommand
   * @exception ProcessingException
   */
  public void unAssignVoltageSetPoint(
      UnAssignVoltageSetPointFromStaticVarCompensatorCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      StaticVarCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign VoltageSetPoint on StaticVarCompensator";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return StaticVarCompensator
   */
  private StaticVarCompensator load(UUID id) throws ProcessingException {
    staticVarCompensator =
        StaticVarCompensatorBusinessDelegate.getStaticVarCompensatorInstance()
            .getStaticVarCompensator(new StaticVarCompensatorFetchOneSummary(id));
    return staticVarCompensator;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private StaticVarCompensator staticVarCompensator = null;
  private static final Logger LOGGER =
      Logger.getLogger(StaticVarCompensatorBusinessDelegate.class.getName());
}
