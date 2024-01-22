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
 * SeriesCompensator business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of SeriesCompensator related services in the case of a
 *       SeriesCompensator business related service failing.
 *   <li>Exposes a simpler, uniform SeriesCompensator interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill SeriesCompensator business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class SeriesCompensatorBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public SeriesCompensatorBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * SeriesCompensator Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return SeriesCompensatorBusinessDelegate
   */
  public static SeriesCompensatorBusinessDelegate getSeriesCompensatorInstance() {
    return (new SeriesCompensatorBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createSeriesCompensator(CreateSeriesCompensatorCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getSeriesCompensatorId() == null)
        command.setSeriesCompensatorId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      SeriesCompensatorValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateSeriesCompensatorCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateSeriesCompensatorCommand of SeriesCompensator is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create SeriesCompensator - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateSeriesCompensatorCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateSeriesCompensator(UpdateSeriesCompensatorCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      SeriesCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateSeriesCompensatorCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save SeriesCompensator - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteSeriesCompensatorCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteSeriesCompensatorCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SeriesCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteSeriesCompensatorCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete SeriesCompensator using Id = " + command.getSeriesCompensatorId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the SeriesCompensator via SeriesCompensatorFetchOneSummary
   *
   * @param summary SeriesCompensatorFetchOneSummary
   * @return SeriesCompensatorFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public SeriesCompensator getSeriesCompensator(SeriesCompensatorFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("SeriesCompensatorFetchOneSummary arg cannot be null");

    SeriesCompensator entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      SeriesCompensatorValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a SeriesCompensator
      // --------------------------------------
      CompletableFuture<SeriesCompensator> futureEntity =
          queryGateway.query(
              new FindSeriesCompensatorQuery(
                  new LoadSeriesCompensatorFilter(summary.getSeriesCompensatorId())),
              ResponseTypes.instanceOf(SeriesCompensator.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate SeriesCompensator with id " + summary.getSeriesCompensatorId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all SeriesCompensators
   *
   * @return List<SeriesCompensator>
   * @exception ProcessingException Thrown if any problems
   */
  public List<SeriesCompensator> getAllSeriesCompensator() throws ProcessingException {
    List<SeriesCompensator> list = null;

    try {
      CompletableFuture<List<SeriesCompensator>> futureList =
          queryGateway.query(
              new FindAllSeriesCompensatorQuery(),
              ResponseTypes.multipleInstancesOf(SeriesCompensator.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all SeriesCompensator";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign R on SeriesCompensator
   *
   * @param command AssignRToSeriesCompensatorCommand
   * @exception ProcessingException
   */
  public void assignR(AssignRToSeriesCompensatorCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSeriesCompensatorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ResistanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ResistanceBusinessDelegate.getResistanceInstance();
    SeriesCompensatorBusinessDelegate parentDelegate =
        SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance();
    UUID childId = command.getAssignment().getResistanceId();
    Resistance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SeriesCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Resistance using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign R on SeriesCompensator
   *
   * @param command UnAssignRFromSeriesCompensatorCommand
   * @exception ProcessingException
   */
  public void unAssignR(UnAssignRFromSeriesCompensatorCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SeriesCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign R on SeriesCompensator";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign R0 on SeriesCompensator
   *
   * @param command AssignR0ToSeriesCompensatorCommand
   * @exception ProcessingException
   */
  public void assignR0(AssignR0ToSeriesCompensatorCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSeriesCompensatorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ResistanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ResistanceBusinessDelegate.getResistanceInstance();
    SeriesCompensatorBusinessDelegate parentDelegate =
        SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance();
    UUID childId = command.getAssignment().getResistanceId();
    Resistance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SeriesCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Resistance using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign R0 on SeriesCompensator
   *
   * @param command UnAssignR0FromSeriesCompensatorCommand
   * @exception ProcessingException
   */
  public void unAssignR0(UnAssignR0FromSeriesCompensatorCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SeriesCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign R0 on SeriesCompensator";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign VaristorPresent on SeriesCompensator
   *
   * @param command AssignVaristorPresentToSeriesCompensatorCommand
   * @exception ProcessingException
   */
  public void assignVaristorPresent(AssignVaristorPresentToSeriesCompensatorCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSeriesCompensatorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    SeriesCompensatorBusinessDelegate parentDelegate =
        SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SeriesCompensatorValidator.getInstance().validate(command);

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
   * unAssign VaristorPresent on SeriesCompensator
   *
   * @param command UnAssignVaristorPresentFromSeriesCompensatorCommand
   * @exception ProcessingException
   */
  public void unAssignVaristorPresent(UnAssignVaristorPresentFromSeriesCompensatorCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SeriesCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign VaristorPresent on SeriesCompensator";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign VaristorRatedCurrent on SeriesCompensator
   *
   * @param command AssignVaristorRatedCurrentToSeriesCompensatorCommand
   * @exception ProcessingException
   */
  public void assignVaristorRatedCurrent(
      AssignVaristorRatedCurrentToSeriesCompensatorCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSeriesCompensatorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .CurrentFlowBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .CurrentFlowBusinessDelegate.getCurrentFlowInstance();
    SeriesCompensatorBusinessDelegate parentDelegate =
        SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance();
    UUID childId = command.getAssignment().getCurrentFlowId();
    CurrentFlow child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SeriesCompensatorValidator.getInstance().validate(command);

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
   * unAssign VaristorRatedCurrent on SeriesCompensator
   *
   * @param command UnAssignVaristorRatedCurrentFromSeriesCompensatorCommand
   * @exception ProcessingException
   */
  public void unAssignVaristorRatedCurrent(
      UnAssignVaristorRatedCurrentFromSeriesCompensatorCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SeriesCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign VaristorRatedCurrent on SeriesCompensator";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign VaristorVoltageThreshold on SeriesCompensator
   *
   * @param command AssignVaristorVoltageThresholdToSeriesCompensatorCommand
   * @exception ProcessingException
   */
  public void assignVaristorVoltageThreshold(
      AssignVaristorVoltageThresholdToSeriesCompensatorCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSeriesCompensatorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .VoltageBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .VoltageBusinessDelegate.getVoltageInstance();
    SeriesCompensatorBusinessDelegate parentDelegate =
        SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance();
    UUID childId = command.getAssignment().getVoltageId();
    Voltage child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SeriesCompensatorValidator.getInstance().validate(command);

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
   * unAssign VaristorVoltageThreshold on SeriesCompensator
   *
   * @param command UnAssignVaristorVoltageThresholdFromSeriesCompensatorCommand
   * @exception ProcessingException
   */
  public void unAssignVaristorVoltageThreshold(
      UnAssignVaristorVoltageThresholdFromSeriesCompensatorCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SeriesCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign VaristorVoltageThreshold on SeriesCompensator";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign X on SeriesCompensator
   *
   * @param command AssignXToSeriesCompensatorCommand
   * @exception ProcessingException
   */
  public void assignX(AssignXToSeriesCompensatorCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSeriesCompensatorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ReactanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ReactanceBusinessDelegate.getReactanceInstance();
    SeriesCompensatorBusinessDelegate parentDelegate =
        SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance();
    UUID childId = command.getAssignment().getReactanceId();
    Reactance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SeriesCompensatorValidator.getInstance().validate(command);

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
   * unAssign X on SeriesCompensator
   *
   * @param command UnAssignXFromSeriesCompensatorCommand
   * @exception ProcessingException
   */
  public void unAssignX(UnAssignXFromSeriesCompensatorCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SeriesCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign X on SeriesCompensator";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign X0 on SeriesCompensator
   *
   * @param command AssignX0ToSeriesCompensatorCommand
   * @exception ProcessingException
   */
  public void assignX0(AssignX0ToSeriesCompensatorCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSeriesCompensatorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ReactanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ReactanceBusinessDelegate.getReactanceInstance();
    SeriesCompensatorBusinessDelegate parentDelegate =
        SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance();
    UUID childId = command.getAssignment().getReactanceId();
    Reactance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SeriesCompensatorValidator.getInstance().validate(command);

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
   * unAssign X0 on SeriesCompensator
   *
   * @param command UnAssignX0FromSeriesCompensatorCommand
   * @exception ProcessingException
   */
  public void unAssignX0(UnAssignX0FromSeriesCompensatorCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SeriesCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign X0 on SeriesCompensator";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return SeriesCompensator
   */
  private SeriesCompensator load(UUID id) throws ProcessingException {
    seriesCompensator =
        SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance()
            .getSeriesCompensator(new SeriesCompensatorFetchOneSummary(id));
    return seriesCompensator;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private SeriesCompensator seriesCompensator = null;
  private static final Logger LOGGER =
      Logger.getLogger(SeriesCompensatorBusinessDelegate.class.getName());
}
