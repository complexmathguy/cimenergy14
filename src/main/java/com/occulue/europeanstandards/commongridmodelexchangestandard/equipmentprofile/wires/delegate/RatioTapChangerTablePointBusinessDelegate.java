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
 * RatioTapChangerTablePoint business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of RatioTapChangerTablePoint related services in the case of a
 *       RatioTapChangerTablePoint business related service failing.
 *   <li>Exposes a simpler, uniform RatioTapChangerTablePoint interface to the business tier, making
 *       it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill RatioTapChangerTablePoint
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class RatioTapChangerTablePointBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public RatioTapChangerTablePointBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * RatioTapChangerTablePoint Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return RatioTapChangerTablePointBusinessDelegate
   */
  public static RatioTapChangerTablePointBusinessDelegate getRatioTapChangerTablePointInstance() {
    return (new RatioTapChangerTablePointBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createRatioTapChangerTablePoint(
      CreateRatioTapChangerTablePointCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getRatioTapChangerTablePointId() == null)
        command.setRatioTapChangerTablePointId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      RatioTapChangerTablePointValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateRatioTapChangerTablePointCommand - by convention the future return value
      // for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateRatioTapChangerTablePointCommand of RatioTapChangerTablePoint is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create RatioTapChangerTablePoint - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateRatioTapChangerTablePointCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateRatioTapChangerTablePoint(
      UpdateRatioTapChangerTablePointCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      RatioTapChangerTablePointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateRatioTapChangerTablePointCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save RatioTapChangerTablePoint - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteRatioTapChangerTablePointCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteRatioTapChangerTablePointCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      RatioTapChangerTablePointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteRatioTapChangerTablePointCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete RatioTapChangerTablePoint using Id = "
              + command.getRatioTapChangerTablePointId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the RatioTapChangerTablePoint via RatioTapChangerTablePointFetchOneSummary
   *
   * @param summary RatioTapChangerTablePointFetchOneSummary
   * @return RatioTapChangerTablePointFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public RatioTapChangerTablePoint getRatioTapChangerTablePoint(
      RatioTapChangerTablePointFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "RatioTapChangerTablePointFetchOneSummary arg cannot be null");

    RatioTapChangerTablePoint entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      RatioTapChangerTablePointValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a RatioTapChangerTablePoint
      // --------------------------------------
      CompletableFuture<RatioTapChangerTablePoint> futureEntity =
          queryGateway.query(
              new FindRatioTapChangerTablePointQuery(
                  new LoadRatioTapChangerTablePointFilter(
                      summary.getRatioTapChangerTablePointId())),
              ResponseTypes.instanceOf(RatioTapChangerTablePoint.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate RatioTapChangerTablePoint with id "
              + summary.getRatioTapChangerTablePointId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all RatioTapChangerTablePoints
   *
   * @return List<RatioTapChangerTablePoint>
   * @exception ProcessingException Thrown if any problems
   */
  public List<RatioTapChangerTablePoint> getAllRatioTapChangerTablePoint()
      throws ProcessingException {
    List<RatioTapChangerTablePoint> list = null;

    try {
      CompletableFuture<List<RatioTapChangerTablePoint>> futureList =
          queryGateway.query(
              new FindAllRatioTapChangerTablePointQuery(),
              ResponseTypes.multipleInstancesOf(RatioTapChangerTablePoint.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all RatioTapChangerTablePoint";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * add RatioTapChangerTablePoint to RatioTapChangerTablePoint
   *
   * @param command AssignRatioTapChangerTablePointToRatioTapChangerTablePointCommand
   * @exception ProcessingException
   */
  public void addToRatioTapChangerTablePoint(
      AssignRatioTapChangerTablePointToRatioTapChangerTablePointCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getRatioTapChangerTablePointId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate
            .RatioTapChangerTablePointBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
                .delegate.RatioTapChangerTablePointBusinessDelegate
                .getRatioTapChangerTablePointInstance();
    RatioTapChangerTablePointBusinessDelegate parentDelegate =
        RatioTapChangerTablePointBusinessDelegate.getRatioTapChangerTablePointInstance();
    UUID childId = command.getAddTo().getRatioTapChangerTablePointId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      RatioTapChangerTablePointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg =
          "Failed to add a RatioTapChangerTablePoint as RatioTapChangerTablePoint to RatioTapChangerTablePoint";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove RatioTapChangerTablePoint from RatioTapChangerTablePoint
   *
   * @param command RemoveRatioTapChangerTablePointFromRatioTapChangerTablePointCommand
   * @exception ProcessingException
   */
  public void removeFromRatioTapChangerTablePoint(
      RemoveRatioTapChangerTablePointFromRatioTapChangerTablePointCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate
            .RatioTapChangerTablePointBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
                .delegate.RatioTapChangerTablePointBusinessDelegate
                .getRatioTapChangerTablePointInstance();
    UUID childId = command.getRemoveFrom().getRatioTapChangerTablePointId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      RatioTapChangerTablePointValidator.getInstance().validate(command);

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
   * @return RatioTapChangerTablePoint
   */
  private RatioTapChangerTablePoint load(UUID id) throws ProcessingException {
    ratioTapChangerTablePoint =
        RatioTapChangerTablePointBusinessDelegate.getRatioTapChangerTablePointInstance()
            .getRatioTapChangerTablePoint(new RatioTapChangerTablePointFetchOneSummary(id));
    return ratioTapChangerTablePoint;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private RatioTapChangerTablePoint ratioTapChangerTablePoint = null;
  private static final Logger LOGGER =
      Logger.getLogger(RatioTapChangerTablePointBusinessDelegate.class.getName());
}
