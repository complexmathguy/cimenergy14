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
 * NonlinearShuntCompensatorPoint business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of NonlinearShuntCompensatorPoint related services in the case of a
 *       NonlinearShuntCompensatorPoint business related service failing.
 *   <li>Exposes a simpler, uniform NonlinearShuntCompensatorPoint interface to the business tier,
 *       making it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill
 *       NonlinearShuntCompensatorPoint business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class NonlinearShuntCompensatorPointBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public NonlinearShuntCompensatorPointBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * NonlinearShuntCompensatorPoint Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return NonlinearShuntCompensatorPointBusinessDelegate
   */
  public static NonlinearShuntCompensatorPointBusinessDelegate
      getNonlinearShuntCompensatorPointInstance() {
    return (new NonlinearShuntCompensatorPointBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createNonlinearShuntCompensatorPoint(
      CreateNonlinearShuntCompensatorPointCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getNonlinearShuntCompensatorPointId() == null)
        command.setNonlinearShuntCompensatorPointId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      NonlinearShuntCompensatorPointValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateNonlinearShuntCompensatorPointCommand - by convention the future return
      // value for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateNonlinearShuntCompensatorPointCommand of NonlinearShuntCompensatorPoint is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create NonlinearShuntCompensatorPoint - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateNonlinearShuntCompensatorPointCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateNonlinearShuntCompensatorPoint(
      UpdateNonlinearShuntCompensatorPointCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      NonlinearShuntCompensatorPointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateNonlinearShuntCompensatorPointCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save NonlinearShuntCompensatorPoint - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteNonlinearShuntCompensatorPointCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteNonlinearShuntCompensatorPointCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      NonlinearShuntCompensatorPointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteNonlinearShuntCompensatorPointCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete NonlinearShuntCompensatorPoint using Id = "
              + command.getNonlinearShuntCompensatorPointId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the NonlinearShuntCompensatorPoint via
   * NonlinearShuntCompensatorPointFetchOneSummary
   *
   * @param summary NonlinearShuntCompensatorPointFetchOneSummary
   * @return NonlinearShuntCompensatorPointFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public NonlinearShuntCompensatorPoint getNonlinearShuntCompensatorPoint(
      NonlinearShuntCompensatorPointFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "NonlinearShuntCompensatorPointFetchOneSummary arg cannot be null");

    NonlinearShuntCompensatorPoint entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      NonlinearShuntCompensatorPointValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a NonlinearShuntCompensatorPoint
      // --------------------------------------
      CompletableFuture<NonlinearShuntCompensatorPoint> futureEntity =
          queryGateway.query(
              new FindNonlinearShuntCompensatorPointQuery(
                  new LoadNonlinearShuntCompensatorPointFilter(
                      summary.getNonlinearShuntCompensatorPointId())),
              ResponseTypes.instanceOf(NonlinearShuntCompensatorPoint.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate NonlinearShuntCompensatorPoint with id "
              + summary.getNonlinearShuntCompensatorPointId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all NonlinearShuntCompensatorPoints
   *
   * @return List<NonlinearShuntCompensatorPoint>
   * @exception ProcessingException Thrown if any problems
   */
  public List<NonlinearShuntCompensatorPoint> getAllNonlinearShuntCompensatorPoint()
      throws ProcessingException {
    List<NonlinearShuntCompensatorPoint> list = null;

    try {
      CompletableFuture<List<NonlinearShuntCompensatorPoint>> futureList =
          queryGateway.query(
              new FindAllNonlinearShuntCompensatorPointQuery(),
              ResponseTypes.multipleInstancesOf(NonlinearShuntCompensatorPoint.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all NonlinearShuntCompensatorPoint";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign B on NonlinearShuntCompensatorPoint
   *
   * @param command AssignBToNonlinearShuntCompensatorPointCommand
   * @exception ProcessingException
   */
  public void assignB(AssignBToNonlinearShuntCompensatorPointCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getNonlinearShuntCompensatorPointId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SusceptanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SusceptanceBusinessDelegate.getSusceptanceInstance();
    NonlinearShuntCompensatorPointBusinessDelegate parentDelegate =
        NonlinearShuntCompensatorPointBusinessDelegate.getNonlinearShuntCompensatorPointInstance();
    UUID childId = command.getAssignment().getSusceptanceId();
    Susceptance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      NonlinearShuntCompensatorPointValidator.getInstance().validate(command);

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
   * unAssign B on NonlinearShuntCompensatorPoint
   *
   * @param command UnAssignBFromNonlinearShuntCompensatorPointCommand
   * @exception ProcessingException
   */
  public void unAssignB(UnAssignBFromNonlinearShuntCompensatorPointCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      NonlinearShuntCompensatorPointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign B on NonlinearShuntCompensatorPoint";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign B0 on NonlinearShuntCompensatorPoint
   *
   * @param command AssignB0ToNonlinearShuntCompensatorPointCommand
   * @exception ProcessingException
   */
  public void assignB0(AssignB0ToNonlinearShuntCompensatorPointCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getNonlinearShuntCompensatorPointId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SusceptanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SusceptanceBusinessDelegate.getSusceptanceInstance();
    NonlinearShuntCompensatorPointBusinessDelegate parentDelegate =
        NonlinearShuntCompensatorPointBusinessDelegate.getNonlinearShuntCompensatorPointInstance();
    UUID childId = command.getAssignment().getSusceptanceId();
    Susceptance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      NonlinearShuntCompensatorPointValidator.getInstance().validate(command);

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
   * unAssign B0 on NonlinearShuntCompensatorPoint
   *
   * @param command UnAssignB0FromNonlinearShuntCompensatorPointCommand
   * @exception ProcessingException
   */
  public void unAssignB0(UnAssignB0FromNonlinearShuntCompensatorPointCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      NonlinearShuntCompensatorPointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign B0 on NonlinearShuntCompensatorPoint";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign G on NonlinearShuntCompensatorPoint
   *
   * @param command AssignGToNonlinearShuntCompensatorPointCommand
   * @exception ProcessingException
   */
  public void assignG(AssignGToNonlinearShuntCompensatorPointCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getNonlinearShuntCompensatorPointId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ConductanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ConductanceBusinessDelegate.getConductanceInstance();
    NonlinearShuntCompensatorPointBusinessDelegate parentDelegate =
        NonlinearShuntCompensatorPointBusinessDelegate.getNonlinearShuntCompensatorPointInstance();
    UUID childId = command.getAssignment().getConductanceId();
    Conductance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      NonlinearShuntCompensatorPointValidator.getInstance().validate(command);

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
   * unAssign G on NonlinearShuntCompensatorPoint
   *
   * @param command UnAssignGFromNonlinearShuntCompensatorPointCommand
   * @exception ProcessingException
   */
  public void unAssignG(UnAssignGFromNonlinearShuntCompensatorPointCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      NonlinearShuntCompensatorPointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign G on NonlinearShuntCompensatorPoint";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign G0 on NonlinearShuntCompensatorPoint
   *
   * @param command AssignG0ToNonlinearShuntCompensatorPointCommand
   * @exception ProcessingException
   */
  public void assignG0(AssignG0ToNonlinearShuntCompensatorPointCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getNonlinearShuntCompensatorPointId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ConductanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ConductanceBusinessDelegate.getConductanceInstance();
    NonlinearShuntCompensatorPointBusinessDelegate parentDelegate =
        NonlinearShuntCompensatorPointBusinessDelegate.getNonlinearShuntCompensatorPointInstance();
    UUID childId = command.getAssignment().getConductanceId();
    Conductance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      NonlinearShuntCompensatorPointValidator.getInstance().validate(command);

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
   * unAssign G0 on NonlinearShuntCompensatorPoint
   *
   * @param command UnAssignG0FromNonlinearShuntCompensatorPointCommand
   * @exception ProcessingException
   */
  public void unAssignG0(UnAssignG0FromNonlinearShuntCompensatorPointCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      NonlinearShuntCompensatorPointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign G0 on NonlinearShuntCompensatorPoint";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign SectionNumber on NonlinearShuntCompensatorPoint
   *
   * @param command AssignSectionNumberToNonlinearShuntCompensatorPointCommand
   * @exception ProcessingException
   */
  public void assignSectionNumber(
      AssignSectionNumberToNonlinearShuntCompensatorPointCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getNonlinearShuntCompensatorPointId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .IntegerProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .IntegerProxyBusinessDelegate.getIntegerProxyInstance();
    NonlinearShuntCompensatorPointBusinessDelegate parentDelegate =
        NonlinearShuntCompensatorPointBusinessDelegate.getNonlinearShuntCompensatorPointInstance();
    UUID childId = command.getAssignment().getIntegerProxyId();
    IntegerProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      NonlinearShuntCompensatorPointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get IntegerProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign SectionNumber on NonlinearShuntCompensatorPoint
   *
   * @param command UnAssignSectionNumberFromNonlinearShuntCompensatorPointCommand
   * @exception ProcessingException
   */
  public void unAssignSectionNumber(
      UnAssignSectionNumberFromNonlinearShuntCompensatorPointCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      NonlinearShuntCompensatorPointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign SectionNumber on NonlinearShuntCompensatorPoint";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * add NonlinearShuntCompensatorPoint to NonlinearShuntCompensatorPoints
   *
   * @param command AssignNonlinearShuntCompensatorPointsToNonlinearShuntCompensatorPointCommand
   * @exception ProcessingException
   */
  public void addToNonlinearShuntCompensatorPoints(
      AssignNonlinearShuntCompensatorPointsToNonlinearShuntCompensatorPointCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getNonlinearShuntCompensatorPointId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate
            .NonlinearShuntCompensatorPointBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
                .delegate.NonlinearShuntCompensatorPointBusinessDelegate
                .getNonlinearShuntCompensatorPointInstance();
    NonlinearShuntCompensatorPointBusinessDelegate parentDelegate =
        NonlinearShuntCompensatorPointBusinessDelegate.getNonlinearShuntCompensatorPointInstance();
    UUID childId = command.getAddTo().getNonlinearShuntCompensatorPointId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      NonlinearShuntCompensatorPointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg =
          "Failed to add a NonlinearShuntCompensatorPoint as NonlinearShuntCompensatorPoints to NonlinearShuntCompensatorPoint";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove NonlinearShuntCompensatorPoint from NonlinearShuntCompensatorPoints
   *
   * @param command RemoveNonlinearShuntCompensatorPointsFromNonlinearShuntCompensatorPointCommand
   * @exception ProcessingException
   */
  public void removeFromNonlinearShuntCompensatorPoints(
      RemoveNonlinearShuntCompensatorPointsFromNonlinearShuntCompensatorPointCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate
            .NonlinearShuntCompensatorPointBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
                .delegate.NonlinearShuntCompensatorPointBusinessDelegate
                .getNonlinearShuntCompensatorPointInstance();
    UUID childId = command.getRemoveFrom().getNonlinearShuntCompensatorPointId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      NonlinearShuntCompensatorPointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Exception exc) {
      final String msg = "Failed to remove child using Id " + childId;
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return NonlinearShuntCompensatorPoint
   */
  private NonlinearShuntCompensatorPoint load(UUID id) throws ProcessingException {
    nonlinearShuntCompensatorPoint =
        NonlinearShuntCompensatorPointBusinessDelegate.getNonlinearShuntCompensatorPointInstance()
            .getNonlinearShuntCompensatorPoint(
                new NonlinearShuntCompensatorPointFetchOneSummary(id));
    return nonlinearShuntCompensatorPoint;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private NonlinearShuntCompensatorPoint nonlinearShuntCompensatorPoint = null;
  private static final Logger LOGGER =
      Logger.getLogger(NonlinearShuntCompensatorPointBusinessDelegate.class.getName());
}
