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
 * SwitchSchedule business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of SwitchSchedule related services in the case of a SwitchSchedule
 *       business related service failing.
 *   <li>Exposes a simpler, uniform SwitchSchedule interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill SwitchSchedule business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class SwitchScheduleBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public SwitchScheduleBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * SwitchSchedule Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return SwitchScheduleBusinessDelegate
   */
  public static SwitchScheduleBusinessDelegate getSwitchScheduleInstance() {
    return (new SwitchScheduleBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createSwitchSchedule(CreateSwitchScheduleCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getSwitchScheduleId() == null) command.setSwitchScheduleId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      SwitchScheduleValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateSwitchScheduleCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateSwitchScheduleCommand of SwitchSchedule is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create SwitchSchedule - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateSwitchScheduleCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateSwitchSchedule(UpdateSwitchScheduleCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      SwitchScheduleValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateSwitchScheduleCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save SwitchSchedule - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteSwitchScheduleCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteSwitchScheduleCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SwitchScheduleValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteSwitchScheduleCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete SwitchSchedule using Id = " + command.getSwitchScheduleId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the SwitchSchedule via SwitchScheduleFetchOneSummary
   *
   * @param summary SwitchScheduleFetchOneSummary
   * @return SwitchScheduleFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public SwitchSchedule getSwitchSchedule(SwitchScheduleFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("SwitchScheduleFetchOneSummary arg cannot be null");

    SwitchSchedule entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      SwitchScheduleValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a SwitchSchedule
      // --------------------------------------
      CompletableFuture<SwitchSchedule> futureEntity =
          queryGateway.query(
              new FindSwitchScheduleQuery(
                  new LoadSwitchScheduleFilter(summary.getSwitchScheduleId())),
              ResponseTypes.instanceOf(SwitchSchedule.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate SwitchSchedule with id " + summary.getSwitchScheduleId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all SwitchSchedules
   *
   * @return List<SwitchSchedule>
   * @exception ProcessingException Thrown if any problems
   */
  public List<SwitchSchedule> getAllSwitchSchedule() throws ProcessingException {
    List<SwitchSchedule> list = null;

    try {
      CompletableFuture<List<SwitchSchedule>> futureList =
          queryGateway.query(
              new FindAllSwitchScheduleQuery(),
              ResponseTypes.multipleInstancesOf(SwitchSchedule.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all SwitchSchedule";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * add SwitchSchedule to SwitchSchedules
   *
   * @param command AssignSwitchSchedulesToSwitchScheduleCommand
   * @exception ProcessingException
   */
  public void addToSwitchSchedules(AssignSwitchSchedulesToSwitchScheduleCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getSwitchScheduleId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate
            .SwitchScheduleBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
                .delegate.SwitchScheduleBusinessDelegate.getSwitchScheduleInstance();
    SwitchScheduleBusinessDelegate parentDelegate =
        SwitchScheduleBusinessDelegate.getSwitchScheduleInstance();
    UUID childId = command.getAddTo().getSwitchScheduleId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SwitchScheduleValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a SwitchSchedule as SwitchSchedules to SwitchSchedule";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove SwitchSchedule from SwitchSchedules
   *
   * @param command RemoveSwitchSchedulesFromSwitchScheduleCommand
   * @exception ProcessingException
   */
  public void removeFromSwitchSchedules(RemoveSwitchSchedulesFromSwitchScheduleCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate
            .SwitchScheduleBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
                .delegate.SwitchScheduleBusinessDelegate.getSwitchScheduleInstance();
    UUID childId = command.getRemoveFrom().getSwitchScheduleId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      SwitchScheduleValidator.getInstance().validate(command);

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
   * @return SwitchSchedule
   */
  private SwitchSchedule load(UUID id) throws ProcessingException {
    switchSchedule =
        SwitchScheduleBusinessDelegate.getSwitchScheduleInstance()
            .getSwitchSchedule(new SwitchScheduleFetchOneSummary(id));
    return switchSchedule;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private SwitchSchedule switchSchedule = null;
  private static final Logger LOGGER =
      Logger.getLogger(SwitchScheduleBusinessDelegate.class.getName());
}
