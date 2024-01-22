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
 * LinearShuntCompensator business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of LinearShuntCompensator related services in the case of a
 *       LinearShuntCompensator business related service failing.
 *   <li>Exposes a simpler, uniform LinearShuntCompensator interface to the business tier, making it
 *       easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill LinearShuntCompensator
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class LinearShuntCompensatorBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public LinearShuntCompensatorBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * LinearShuntCompensator Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return LinearShuntCompensatorBusinessDelegate
   */
  public static LinearShuntCompensatorBusinessDelegate getLinearShuntCompensatorInstance() {
    return (new LinearShuntCompensatorBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createLinearShuntCompensator(
      CreateLinearShuntCompensatorCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getLinearShuntCompensatorId() == null)
        command.setLinearShuntCompensatorId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      LinearShuntCompensatorValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateLinearShuntCompensatorCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateLinearShuntCompensatorCommand of LinearShuntCompensator is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create LinearShuntCompensator - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateLinearShuntCompensatorCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateLinearShuntCompensator(
      UpdateLinearShuntCompensatorCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      LinearShuntCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateLinearShuntCompensatorCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save LinearShuntCompensator - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteLinearShuntCompensatorCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteLinearShuntCompensatorCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LinearShuntCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteLinearShuntCompensatorCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete LinearShuntCompensator using Id = "
              + command.getLinearShuntCompensatorId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the LinearShuntCompensator via LinearShuntCompensatorFetchOneSummary
   *
   * @param summary LinearShuntCompensatorFetchOneSummary
   * @return LinearShuntCompensatorFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public LinearShuntCompensator getLinearShuntCompensator(
      LinearShuntCompensatorFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "LinearShuntCompensatorFetchOneSummary arg cannot be null");

    LinearShuntCompensator entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      LinearShuntCompensatorValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a LinearShuntCompensator
      // --------------------------------------
      CompletableFuture<LinearShuntCompensator> futureEntity =
          queryGateway.query(
              new FindLinearShuntCompensatorQuery(
                  new LoadLinearShuntCompensatorFilter(summary.getLinearShuntCompensatorId())),
              ResponseTypes.instanceOf(LinearShuntCompensator.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate LinearShuntCompensator with id "
              + summary.getLinearShuntCompensatorId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all LinearShuntCompensators
   *
   * @return List<LinearShuntCompensator>
   * @exception ProcessingException Thrown if any problems
   */
  public List<LinearShuntCompensator> getAllLinearShuntCompensator() throws ProcessingException {
    List<LinearShuntCompensator> list = null;

    try {
      CompletableFuture<List<LinearShuntCompensator>> futureList =
          queryGateway.query(
              new FindAllLinearShuntCompensatorQuery(),
              ResponseTypes.multipleInstancesOf(LinearShuntCompensator.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all LinearShuntCompensator";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign B0PerSection on LinearShuntCompensator
   *
   * @param command AssignB0PerSectionToLinearShuntCompensatorCommand
   * @exception ProcessingException
   */
  public void assignB0PerSection(AssignB0PerSectionToLinearShuntCompensatorCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLinearShuntCompensatorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SusceptanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SusceptanceBusinessDelegate.getSusceptanceInstance();
    LinearShuntCompensatorBusinessDelegate parentDelegate =
        LinearShuntCompensatorBusinessDelegate.getLinearShuntCompensatorInstance();
    UUID childId = command.getAssignment().getSusceptanceId();
    Susceptance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LinearShuntCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Susceptance using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign B0PerSection on LinearShuntCompensator
   *
   * @param command UnAssignB0PerSectionFromLinearShuntCompensatorCommand
   * @exception ProcessingException
   */
  public void unAssignB0PerSection(UnAssignB0PerSectionFromLinearShuntCompensatorCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LinearShuntCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign B0PerSection on LinearShuntCompensator";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign BPerSection on LinearShuntCompensator
   *
   * @param command AssignBPerSectionToLinearShuntCompensatorCommand
   * @exception ProcessingException
   */
  public void assignBPerSection(AssignBPerSectionToLinearShuntCompensatorCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLinearShuntCompensatorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SusceptanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SusceptanceBusinessDelegate.getSusceptanceInstance();
    LinearShuntCompensatorBusinessDelegate parentDelegate =
        LinearShuntCompensatorBusinessDelegate.getLinearShuntCompensatorInstance();
    UUID childId = command.getAssignment().getSusceptanceId();
    Susceptance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LinearShuntCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Susceptance using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign BPerSection on LinearShuntCompensator
   *
   * @param command UnAssignBPerSectionFromLinearShuntCompensatorCommand
   * @exception ProcessingException
   */
  public void unAssignBPerSection(UnAssignBPerSectionFromLinearShuntCompensatorCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LinearShuntCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign BPerSection on LinearShuntCompensator";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign G0PerSection on LinearShuntCompensator
   *
   * @param command AssignG0PerSectionToLinearShuntCompensatorCommand
   * @exception ProcessingException
   */
  public void assignG0PerSection(AssignG0PerSectionToLinearShuntCompensatorCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLinearShuntCompensatorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ConductanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ConductanceBusinessDelegate.getConductanceInstance();
    LinearShuntCompensatorBusinessDelegate parentDelegate =
        LinearShuntCompensatorBusinessDelegate.getLinearShuntCompensatorInstance();
    UUID childId = command.getAssignment().getConductanceId();
    Conductance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LinearShuntCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Conductance using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign G0PerSection on LinearShuntCompensator
   *
   * @param command UnAssignG0PerSectionFromLinearShuntCompensatorCommand
   * @exception ProcessingException
   */
  public void unAssignG0PerSection(UnAssignG0PerSectionFromLinearShuntCompensatorCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LinearShuntCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign G0PerSection on LinearShuntCompensator";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign GPerSection on LinearShuntCompensator
   *
   * @param command AssignGPerSectionToLinearShuntCompensatorCommand
   * @exception ProcessingException
   */
  public void assignGPerSection(AssignGPerSectionToLinearShuntCompensatorCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLinearShuntCompensatorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ConductanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ConductanceBusinessDelegate.getConductanceInstance();
    LinearShuntCompensatorBusinessDelegate parentDelegate =
        LinearShuntCompensatorBusinessDelegate.getLinearShuntCompensatorInstance();
    UUID childId = command.getAssignment().getConductanceId();
    Conductance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LinearShuntCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Conductance using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign GPerSection on LinearShuntCompensator
   *
   * @param command UnAssignGPerSectionFromLinearShuntCompensatorCommand
   * @exception ProcessingException
   */
  public void unAssignGPerSection(UnAssignGPerSectionFromLinearShuntCompensatorCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LinearShuntCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign GPerSection on LinearShuntCompensator";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return LinearShuntCompensator
   */
  private LinearShuntCompensator load(UUID id) throws ProcessingException {
    linearShuntCompensator =
        LinearShuntCompensatorBusinessDelegate.getLinearShuntCompensatorInstance()
            .getLinearShuntCompensator(new LinearShuntCompensatorFetchOneSummary(id));
    return linearShuntCompensator;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private LinearShuntCompensator linearShuntCompensator = null;
  private static final Logger LOGGER =
      Logger.getLogger(LinearShuntCompensatorBusinessDelegate.class.getName());
}
