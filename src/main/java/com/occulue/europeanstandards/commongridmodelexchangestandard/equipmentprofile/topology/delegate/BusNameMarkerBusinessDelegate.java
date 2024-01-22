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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.topology.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.topology.validator.*;
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
 * BusNameMarker business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of BusNameMarker related services in the case of a BusNameMarker
 *       business related service failing.
 *   <li>Exposes a simpler, uniform BusNameMarker interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill BusNameMarker business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class BusNameMarkerBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public BusNameMarkerBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * BusNameMarker Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return BusNameMarkerBusinessDelegate
   */
  public static BusNameMarkerBusinessDelegate getBusNameMarkerInstance() {
    return (new BusNameMarkerBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createBusNameMarker(CreateBusNameMarkerCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getBusNameMarkerId() == null) command.setBusNameMarkerId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      BusNameMarkerValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateBusNameMarkerCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateBusNameMarkerCommand of BusNameMarker is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create BusNameMarker - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateBusNameMarkerCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateBusNameMarker(UpdateBusNameMarkerCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      BusNameMarkerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateBusNameMarkerCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save BusNameMarker - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteBusNameMarkerCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteBusNameMarkerCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      BusNameMarkerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteBusNameMarkerCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete BusNameMarker using Id = " + command.getBusNameMarkerId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the BusNameMarker via BusNameMarkerFetchOneSummary
   *
   * @param summary BusNameMarkerFetchOneSummary
   * @return BusNameMarkerFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public BusNameMarker getBusNameMarker(BusNameMarkerFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("BusNameMarkerFetchOneSummary arg cannot be null");

    BusNameMarker entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      BusNameMarkerValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a BusNameMarker
      // --------------------------------------
      CompletableFuture<BusNameMarker> futureEntity =
          queryGateway.query(
              new FindBusNameMarkerQuery(new LoadBusNameMarkerFilter(summary.getBusNameMarkerId())),
              ResponseTypes.instanceOf(BusNameMarker.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate BusNameMarker with id " + summary.getBusNameMarkerId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all BusNameMarkers
   *
   * @return List<BusNameMarker>
   * @exception ProcessingException Thrown if any problems
   */
  public List<BusNameMarker> getAllBusNameMarker() throws ProcessingException {
    List<BusNameMarker> list = null;

    try {
      CompletableFuture<List<BusNameMarker>> futureList =
          queryGateway.query(
              new FindAllBusNameMarkerQuery(),
              ResponseTypes.multipleInstancesOf(BusNameMarker.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all BusNameMarker";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Priority on BusNameMarker
   *
   * @param command AssignPriorityToBusNameMarkerCommand
   * @exception ProcessingException
   */
  public void assignPriority(AssignPriorityToBusNameMarkerCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getBusNameMarkerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .IntegerProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .IntegerProxyBusinessDelegate.getIntegerProxyInstance();
    BusNameMarkerBusinessDelegate parentDelegate =
        BusNameMarkerBusinessDelegate.getBusNameMarkerInstance();
    UUID childId = command.getAssignment().getIntegerProxyId();
    IntegerProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      BusNameMarkerValidator.getInstance().validate(command);

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
   * unAssign Priority on BusNameMarker
   *
   * @param command UnAssignPriorityFromBusNameMarkerCommand
   * @exception ProcessingException
   */
  public void unAssignPriority(UnAssignPriorityFromBusNameMarkerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      BusNameMarkerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Priority on BusNameMarker";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * add BusNameMarker to BusNameMarker
   *
   * @param command AssignBusNameMarkerToBusNameMarkerCommand
   * @exception ProcessingException
   */
  public void addToBusNameMarker(AssignBusNameMarkerToBusNameMarkerCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getBusNameMarkerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.topology.delegate
            .BusNameMarkerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.topology
                .delegate.BusNameMarkerBusinessDelegate.getBusNameMarkerInstance();
    BusNameMarkerBusinessDelegate parentDelegate =
        BusNameMarkerBusinessDelegate.getBusNameMarkerInstance();
    UUID childId = command.getAddTo().getBusNameMarkerId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      BusNameMarkerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a BusNameMarker as BusNameMarker to BusNameMarker";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove BusNameMarker from BusNameMarker
   *
   * @param command RemoveBusNameMarkerFromBusNameMarkerCommand
   * @exception ProcessingException
   */
  public void removeFromBusNameMarker(RemoveBusNameMarkerFromBusNameMarkerCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.topology.delegate
            .BusNameMarkerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.topology
                .delegate.BusNameMarkerBusinessDelegate.getBusNameMarkerInstance();
    UUID childId = command.getRemoveFrom().getBusNameMarkerId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      BusNameMarkerValidator.getInstance().validate(command);

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
   * @return BusNameMarker
   */
  private BusNameMarker load(UUID id) throws ProcessingException {
    busNameMarker =
        BusNameMarkerBusinessDelegate.getBusNameMarkerInstance()
            .getBusNameMarker(new BusNameMarkerFetchOneSummary(id));
    return busNameMarker;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private BusNameMarker busNameMarker = null;
  private static final Logger LOGGER =
      Logger.getLogger(BusNameMarkerBusinessDelegate.class.getName());
}
