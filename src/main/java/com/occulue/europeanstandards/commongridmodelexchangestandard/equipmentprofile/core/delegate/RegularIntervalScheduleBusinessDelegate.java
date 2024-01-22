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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.validator.*;
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
 * RegularIntervalSchedule business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of RegularIntervalSchedule related services in the case of a
 *       RegularIntervalSchedule business related service failing.
 *   <li>Exposes a simpler, uniform RegularIntervalSchedule interface to the business tier, making
 *       it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill RegularIntervalSchedule
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class RegularIntervalScheduleBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public RegularIntervalScheduleBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * RegularIntervalSchedule Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return RegularIntervalScheduleBusinessDelegate
   */
  public static RegularIntervalScheduleBusinessDelegate getRegularIntervalScheduleInstance() {
    return (new RegularIntervalScheduleBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createRegularIntervalSchedule(
      CreateRegularIntervalScheduleCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getRegularIntervalScheduleId() == null)
        command.setRegularIntervalScheduleId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      RegularIntervalScheduleValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateRegularIntervalScheduleCommand - by convention the future return value for
      // a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateRegularIntervalScheduleCommand of RegularIntervalSchedule is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create RegularIntervalSchedule - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateRegularIntervalScheduleCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateRegularIntervalSchedule(
      UpdateRegularIntervalScheduleCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      RegularIntervalScheduleValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateRegularIntervalScheduleCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save RegularIntervalSchedule - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteRegularIntervalScheduleCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteRegularIntervalScheduleCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      RegularIntervalScheduleValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteRegularIntervalScheduleCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete RegularIntervalSchedule using Id = "
              + command.getRegularIntervalScheduleId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the RegularIntervalSchedule via RegularIntervalScheduleFetchOneSummary
   *
   * @param summary RegularIntervalScheduleFetchOneSummary
   * @return RegularIntervalScheduleFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public RegularIntervalSchedule getRegularIntervalSchedule(
      RegularIntervalScheduleFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "RegularIntervalScheduleFetchOneSummary arg cannot be null");

    RegularIntervalSchedule entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      RegularIntervalScheduleValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a RegularIntervalSchedule
      // --------------------------------------
      CompletableFuture<RegularIntervalSchedule> futureEntity =
          queryGateway.query(
              new FindRegularIntervalScheduleQuery(
                  new LoadRegularIntervalScheduleFilter(summary.getRegularIntervalScheduleId())),
              ResponseTypes.instanceOf(RegularIntervalSchedule.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate RegularIntervalSchedule with id "
              + summary.getRegularIntervalScheduleId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all RegularIntervalSchedules
   *
   * @return List<RegularIntervalSchedule>
   * @exception ProcessingException Thrown if any problems
   */
  public List<RegularIntervalSchedule> getAllRegularIntervalSchedule() throws ProcessingException {
    List<RegularIntervalSchedule> list = null;

    try {
      CompletableFuture<List<RegularIntervalSchedule>> futureList =
          queryGateway.query(
              new FindAllRegularIntervalScheduleQuery(),
              ResponseTypes.multipleInstancesOf(RegularIntervalSchedule.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all RegularIntervalSchedule";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign EndTime on RegularIntervalSchedule
   *
   * @param command AssignEndTimeToRegularIntervalScheduleCommand
   * @exception ProcessingException
   */
  public void assignEndTime(AssignEndTimeToRegularIntervalScheduleCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getRegularIntervalScheduleId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .DateTimeBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .DateTimeBusinessDelegate.getDateTimeInstance();
    RegularIntervalScheduleBusinessDelegate parentDelegate =
        RegularIntervalScheduleBusinessDelegate.getRegularIntervalScheduleInstance();
    UUID childId = command.getAssignment().getDateTimeId();
    DateTime child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      RegularIntervalScheduleValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get DateTime using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign EndTime on RegularIntervalSchedule
   *
   * @param command UnAssignEndTimeFromRegularIntervalScheduleCommand
   * @exception ProcessingException
   */
  public void unAssignEndTime(UnAssignEndTimeFromRegularIntervalScheduleCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      RegularIntervalScheduleValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign EndTime on RegularIntervalSchedule";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign TimeStep on RegularIntervalSchedule
   *
   * @param command AssignTimeStepToRegularIntervalScheduleCommand
   * @exception ProcessingException
   */
  public void assignTimeStep(AssignTimeStepToRegularIntervalScheduleCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getRegularIntervalScheduleId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    RegularIntervalScheduleBusinessDelegate parentDelegate =
        RegularIntervalScheduleBusinessDelegate.getRegularIntervalScheduleInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      RegularIntervalScheduleValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Seconds using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign TimeStep on RegularIntervalSchedule
   *
   * @param command UnAssignTimeStepFromRegularIntervalScheduleCommand
   * @exception ProcessingException
   */
  public void unAssignTimeStep(UnAssignTimeStepFromRegularIntervalScheduleCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      RegularIntervalScheduleValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign TimeStep on RegularIntervalSchedule";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return RegularIntervalSchedule
   */
  private RegularIntervalSchedule load(UUID id) throws ProcessingException {
    regularIntervalSchedule =
        RegularIntervalScheduleBusinessDelegate.getRegularIntervalScheduleInstance()
            .getRegularIntervalSchedule(new RegularIntervalScheduleFetchOneSummary(id));
    return regularIntervalSchedule;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private RegularIntervalSchedule regularIntervalSchedule = null;
  private static final Logger LOGGER =
      Logger.getLogger(RegularIntervalScheduleBusinessDelegate.class.getName());
}
