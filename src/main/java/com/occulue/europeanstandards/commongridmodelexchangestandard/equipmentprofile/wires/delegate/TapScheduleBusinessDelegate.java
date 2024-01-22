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
 * TapSchedule business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of TapSchedule related services in the case of a TapSchedule
 *       business related service failing.
 *   <li>Exposes a simpler, uniform TapSchedule interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill TapSchedule business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class TapScheduleBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public TapScheduleBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * TapSchedule Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return TapScheduleBusinessDelegate
   */
  public static TapScheduleBusinessDelegate getTapScheduleInstance() {
    return (new TapScheduleBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createTapSchedule(CreateTapScheduleCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getTapScheduleId() == null) command.setTapScheduleId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      TapScheduleValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateTapScheduleCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateTapScheduleCommand of TapSchedule is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create TapSchedule - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateTapScheduleCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateTapSchedule(UpdateTapScheduleCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      TapScheduleValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateTapScheduleCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save TapSchedule - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteTapScheduleCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteTapScheduleCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TapScheduleValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteTapScheduleCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete TapSchedule using Id = " + command.getTapScheduleId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the TapSchedule via TapScheduleFetchOneSummary
   *
   * @param summary TapScheduleFetchOneSummary
   * @return TapScheduleFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public TapSchedule getTapSchedule(TapScheduleFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("TapScheduleFetchOneSummary arg cannot be null");

    TapSchedule entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      TapScheduleValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a TapSchedule
      // --------------------------------------
      CompletableFuture<TapSchedule> futureEntity =
          queryGateway.query(
              new FindTapScheduleQuery(new LoadTapScheduleFilter(summary.getTapScheduleId())),
              ResponseTypes.instanceOf(TapSchedule.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate TapSchedule with id " + summary.getTapScheduleId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all TapSchedules
   *
   * @return List<TapSchedule>
   * @exception ProcessingException Thrown if any problems
   */
  public List<TapSchedule> getAllTapSchedule() throws ProcessingException {
    List<TapSchedule> list = null;

    try {
      CompletableFuture<List<TapSchedule>> futureList =
          queryGateway.query(
              new FindAllTapScheduleQuery(), ResponseTypes.multipleInstancesOf(TapSchedule.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all TapSchedule";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * add TapSchedule to TapSchedules
   *
   * @param command AssignTapSchedulesToTapScheduleCommand
   * @exception ProcessingException
   */
  public void addToTapSchedules(AssignTapSchedulesToTapScheduleCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getTapScheduleId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate
            .TapScheduleBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
                .delegate.TapScheduleBusinessDelegate.getTapScheduleInstance();
    TapScheduleBusinessDelegate parentDelegate =
        TapScheduleBusinessDelegate.getTapScheduleInstance();
    UUID childId = command.getAddTo().getTapScheduleId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TapScheduleValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a TapSchedule as TapSchedules to TapSchedule";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove TapSchedule from TapSchedules
   *
   * @param command RemoveTapSchedulesFromTapScheduleCommand
   * @exception ProcessingException
   */
  public void removeFromTapSchedules(RemoveTapSchedulesFromTapScheduleCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate
            .TapScheduleBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
                .delegate.TapScheduleBusinessDelegate.getTapScheduleInstance();
    UUID childId = command.getRemoveFrom().getTapScheduleId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      TapScheduleValidator.getInstance().validate(command);

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
   * @return TapSchedule
   */
  private TapSchedule load(UUID id) throws ProcessingException {
    tapSchedule =
        TapScheduleBusinessDelegate.getTapScheduleInstance()
            .getTapSchedule(new TapScheduleFetchOneSummary(id));
    return tapSchedule;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private TapSchedule tapSchedule = null;
  private static final Logger LOGGER =
      Logger.getLogger(TapScheduleBusinessDelegate.class.getName());
}
