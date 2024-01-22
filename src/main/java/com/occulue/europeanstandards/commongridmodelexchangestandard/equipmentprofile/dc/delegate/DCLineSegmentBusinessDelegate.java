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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.validator.*;
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
 * DCLineSegment business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of DCLineSegment related services in the case of a DCLineSegment
 *       business related service failing.
 *   <li>Exposes a simpler, uniform DCLineSegment interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill DCLineSegment business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class DCLineSegmentBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public DCLineSegmentBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * DCLineSegment Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return DCLineSegmentBusinessDelegate
   */
  public static DCLineSegmentBusinessDelegate getDCLineSegmentInstance() {
    return (new DCLineSegmentBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createDCLineSegment(CreateDCLineSegmentCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getDCLineSegmentId() == null) command.setDCLineSegmentId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      DCLineSegmentValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateDCLineSegmentCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateDCLineSegmentCommand of DCLineSegment is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create DCLineSegment - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateDCLineSegmentCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateDCLineSegment(UpdateDCLineSegmentCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      DCLineSegmentValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateDCLineSegmentCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save DCLineSegment - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteDCLineSegmentCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteDCLineSegmentCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DCLineSegmentValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteDCLineSegmentCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete DCLineSegment using Id = " + command.getDCLineSegmentId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the DCLineSegment via DCLineSegmentFetchOneSummary
   *
   * @param summary DCLineSegmentFetchOneSummary
   * @return DCLineSegmentFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public DCLineSegment getDCLineSegment(DCLineSegmentFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("DCLineSegmentFetchOneSummary arg cannot be null");

    DCLineSegment entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      DCLineSegmentValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a DCLineSegment
      // --------------------------------------
      CompletableFuture<DCLineSegment> futureEntity =
          queryGateway.query(
              new FindDCLineSegmentQuery(new LoadDCLineSegmentFilter(summary.getDCLineSegmentId())),
              ResponseTypes.instanceOf(DCLineSegment.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate DCLineSegment with id " + summary.getDCLineSegmentId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all DCLineSegments
   *
   * @return List<DCLineSegment>
   * @exception ProcessingException Thrown if any problems
   */
  public List<DCLineSegment> getAllDCLineSegment() throws ProcessingException {
    List<DCLineSegment> list = null;

    try {
      CompletableFuture<List<DCLineSegment>> futureList =
          queryGateway.query(
              new FindAllDCLineSegmentQuery(),
              ResponseTypes.multipleInstancesOf(DCLineSegment.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all DCLineSegment";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Capacitance on DCLineSegment
   *
   * @param command AssignCapacitanceToDCLineSegmentCommand
   * @exception ProcessingException
   */
  public void assignCapacitance(AssignCapacitanceToDCLineSegmentCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDCLineSegmentId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .CapacitanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .CapacitanceBusinessDelegate.getCapacitanceInstance();
    DCLineSegmentBusinessDelegate parentDelegate =
        DCLineSegmentBusinessDelegate.getDCLineSegmentInstance();
    UUID childId = command.getAssignment().getCapacitanceId();
    Capacitance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DCLineSegmentValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Capacitance using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Capacitance on DCLineSegment
   *
   * @param command UnAssignCapacitanceFromDCLineSegmentCommand
   * @exception ProcessingException
   */
  public void unAssignCapacitance(UnAssignCapacitanceFromDCLineSegmentCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DCLineSegmentValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Capacitance on DCLineSegment";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Inductance on DCLineSegment
   *
   * @param command AssignInductanceToDCLineSegmentCommand
   * @exception ProcessingException
   */
  public void assignInductance(AssignInductanceToDCLineSegmentCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDCLineSegmentId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .InductanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .InductanceBusinessDelegate.getInductanceInstance();
    DCLineSegmentBusinessDelegate parentDelegate =
        DCLineSegmentBusinessDelegate.getDCLineSegmentInstance();
    UUID childId = command.getAssignment().getInductanceId();
    Inductance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DCLineSegmentValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Inductance using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Inductance on DCLineSegment
   *
   * @param command UnAssignInductanceFromDCLineSegmentCommand
   * @exception ProcessingException
   */
  public void unAssignInductance(UnAssignInductanceFromDCLineSegmentCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DCLineSegmentValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Inductance on DCLineSegment";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Length on DCLineSegment
   *
   * @param command AssignLengthToDCLineSegmentCommand
   * @exception ProcessingException
   */
  public void assignLength(AssignLengthToDCLineSegmentCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDCLineSegmentId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .LengthBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .LengthBusinessDelegate.getLengthInstance();
    DCLineSegmentBusinessDelegate parentDelegate =
        DCLineSegmentBusinessDelegate.getDCLineSegmentInstance();
    UUID childId = command.getAssignment().getLengthId();
    Length child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DCLineSegmentValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Length using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Length on DCLineSegment
   *
   * @param command UnAssignLengthFromDCLineSegmentCommand
   * @exception ProcessingException
   */
  public void unAssignLength(UnAssignLengthFromDCLineSegmentCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DCLineSegmentValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Length on DCLineSegment";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Resistance on DCLineSegment
   *
   * @param command AssignResistanceToDCLineSegmentCommand
   * @exception ProcessingException
   */
  public void assignResistance(AssignResistanceToDCLineSegmentCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDCLineSegmentId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ResistanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ResistanceBusinessDelegate.getResistanceInstance();
    DCLineSegmentBusinessDelegate parentDelegate =
        DCLineSegmentBusinessDelegate.getDCLineSegmentInstance();
    UUID childId = command.getAssignment().getResistanceId();
    Resistance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DCLineSegmentValidator.getInstance().validate(command);

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
   * unAssign Resistance on DCLineSegment
   *
   * @param command UnAssignResistanceFromDCLineSegmentCommand
   * @exception ProcessingException
   */
  public void unAssignResistance(UnAssignResistanceFromDCLineSegmentCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DCLineSegmentValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Resistance on DCLineSegment";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * add DCLineSegment to DCLineSegments
   *
   * @param command AssignDCLineSegmentsToDCLineSegmentCommand
   * @exception ProcessingException
   */
  public void addToDCLineSegments(AssignDCLineSegmentsToDCLineSegmentCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getDCLineSegmentId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.delegate
            .DCLineSegmentBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc
                .delegate.DCLineSegmentBusinessDelegate.getDCLineSegmentInstance();
    DCLineSegmentBusinessDelegate parentDelegate =
        DCLineSegmentBusinessDelegate.getDCLineSegmentInstance();
    UUID childId = command.getAddTo().getDCLineSegmentId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DCLineSegmentValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a DCLineSegment as DCLineSegments to DCLineSegment";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove DCLineSegment from DCLineSegments
   *
   * @param command RemoveDCLineSegmentsFromDCLineSegmentCommand
   * @exception ProcessingException
   */
  public void removeFromDCLineSegments(RemoveDCLineSegmentsFromDCLineSegmentCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.delegate
            .DCLineSegmentBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc
                .delegate.DCLineSegmentBusinessDelegate.getDCLineSegmentInstance();
    UUID childId = command.getRemoveFrom().getDCLineSegmentId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      DCLineSegmentValidator.getInstance().validate(command);

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
   * @return DCLineSegment
   */
  private DCLineSegment load(UUID id) throws ProcessingException {
    dCLineSegment =
        DCLineSegmentBusinessDelegate.getDCLineSegmentInstance()
            .getDCLineSegment(new DCLineSegmentFetchOneSummary(id));
    return dCLineSegment;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private DCLineSegment dCLineSegment = null;
  private static final Logger LOGGER =
      Logger.getLogger(DCLineSegmentBusinessDelegate.class.getName());
}
