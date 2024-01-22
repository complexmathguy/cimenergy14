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
package com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.common.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.common.validator.*;
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
 * PositionPoint business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of PositionPoint related services in the case of a PositionPoint
 *       business related service failing.
 *   <li>Exposes a simpler, uniform PositionPoint interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill PositionPoint business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class PositionPointBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public PositionPointBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * PositionPoint Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return PositionPointBusinessDelegate
   */
  public static PositionPointBusinessDelegate getPositionPointInstance() {
    return (new PositionPointBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createPositionPoint(CreatePositionPointCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getPositionPointId() == null) command.setPositionPointId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      PositionPointValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreatePositionPointCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreatePositionPointCommand of PositionPoint is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create PositionPoint - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdatePositionPointCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updatePositionPoint(UpdatePositionPointCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      PositionPointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdatePositionPointCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save PositionPoint - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeletePositionPointCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeletePositionPointCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PositionPointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeletePositionPointCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete PositionPoint using Id = " + command.getPositionPointId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the PositionPoint via PositionPointFetchOneSummary
   *
   * @param summary PositionPointFetchOneSummary
   * @return PositionPointFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public PositionPoint getPositionPoint(PositionPointFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("PositionPointFetchOneSummary arg cannot be null");

    PositionPoint entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      PositionPointValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a PositionPoint
      // --------------------------------------
      CompletableFuture<PositionPoint> futureEntity =
          queryGateway.query(
              new FindPositionPointQuery(new LoadPositionPointFilter(summary.getPositionPointId())),
              ResponseTypes.instanceOf(PositionPoint.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate PositionPoint with id " + summary.getPositionPointId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all PositionPoints
   *
   * @return List<PositionPoint>
   * @exception ProcessingException Thrown if any problems
   */
  public List<PositionPoint> getAllPositionPoint() throws ProcessingException {
    List<PositionPoint> list = null;

    try {
      CompletableFuture<List<PositionPoint>> futureList =
          queryGateway.query(
              new FindAllPositionPointQuery(),
              ResponseTypes.multipleInstancesOf(PositionPoint.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all PositionPoint";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign SequenceNumber on PositionPoint
   *
   * @param command AssignSequenceNumberToPositionPointCommand
   * @exception ProcessingException
   */
  public void assignSequenceNumber(AssignSequenceNumberToPositionPointCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPositionPointId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .IntegerProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .IntegerProxyBusinessDelegate.getIntegerProxyInstance();
    PositionPointBusinessDelegate parentDelegate =
        PositionPointBusinessDelegate.getPositionPointInstance();
    UUID childId = command.getAssignment().getIntegerProxyId();
    IntegerProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PositionPointValidator.getInstance().validate(command);

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
   * unAssign SequenceNumber on PositionPoint
   *
   * @param command UnAssignSequenceNumberFromPositionPointCommand
   * @exception ProcessingException
   */
  public void unAssignSequenceNumber(UnAssignSequenceNumberFromPositionPointCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PositionPointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign SequenceNumber on PositionPoint";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign XPosition on PositionPoint
   *
   * @param command AssignXPositionToPositionPointCommand
   * @exception ProcessingException
   */
  public void assignXPosition(AssignXPositionToPositionPointCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPositionPointId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    PositionPointBusinessDelegate parentDelegate =
        PositionPointBusinessDelegate.getPositionPointInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PositionPointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign XPosition on PositionPoint
   *
   * @param command UnAssignXPositionFromPositionPointCommand
   * @exception ProcessingException
   */
  public void unAssignXPosition(UnAssignXPositionFromPositionPointCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PositionPointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign XPosition on PositionPoint";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign YPosition on PositionPoint
   *
   * @param command AssignYPositionToPositionPointCommand
   * @exception ProcessingException
   */
  public void assignYPosition(AssignYPositionToPositionPointCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPositionPointId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    PositionPointBusinessDelegate parentDelegate =
        PositionPointBusinessDelegate.getPositionPointInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PositionPointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign YPosition on PositionPoint
   *
   * @param command UnAssignYPositionFromPositionPointCommand
   * @exception ProcessingException
   */
  public void unAssignYPosition(UnAssignYPositionFromPositionPointCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PositionPointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign YPosition on PositionPoint";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign ZPosition on PositionPoint
   *
   * @param command AssignZPositionToPositionPointCommand
   * @exception ProcessingException
   */
  public void assignZPosition(AssignZPositionToPositionPointCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPositionPointId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    PositionPointBusinessDelegate parentDelegate =
        PositionPointBusinessDelegate.getPositionPointInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PositionPointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign ZPosition on PositionPoint
   *
   * @param command UnAssignZPositionFromPositionPointCommand
   * @exception ProcessingException
   */
  public void unAssignZPosition(UnAssignZPositionFromPositionPointCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PositionPointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ZPosition on PositionPoint";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * add PositionPoint to PositionPoints
   *
   * @param command AssignPositionPointsToPositionPointCommand
   * @exception ProcessingException
   */
  public void addToPositionPoints(AssignPositionPointsToPositionPointCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getPositionPointId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.common
            .delegate.PositionPointBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard
                .geographicallocationprofile.common.delegate.PositionPointBusinessDelegate
                .getPositionPointInstance();
    PositionPointBusinessDelegate parentDelegate =
        PositionPointBusinessDelegate.getPositionPointInstance();
    UUID childId = command.getAddTo().getPositionPointId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PositionPointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a PositionPoint as PositionPoints to PositionPoint";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove PositionPoint from PositionPoints
   *
   * @param command RemovePositionPointsFromPositionPointCommand
   * @exception ProcessingException
   */
  public void removeFromPositionPoints(RemovePositionPointsFromPositionPointCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.common
            .delegate.PositionPointBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard
                .geographicallocationprofile.common.delegate.PositionPointBusinessDelegate
                .getPositionPointInstance();
    UUID childId = command.getRemoveFrom().getPositionPointId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      PositionPointValidator.getInstance().validate(command);

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
   * @return PositionPoint
   */
  private PositionPoint load(UUID id) throws ProcessingException {
    positionPoint =
        PositionPointBusinessDelegate.getPositionPointInstance()
            .getPositionPoint(new PositionPointFetchOneSummary(id));
    return positionPoint;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private PositionPoint positionPoint = null;
  private static final Logger LOGGER =
      Logger.getLogger(PositionPointBusinessDelegate.class.getName());
}
