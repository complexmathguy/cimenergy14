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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.validator.*;
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
 * MonthDayInterval business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of MonthDayInterval related services in the case of a
 *       MonthDayInterval business related service failing.
 *   <li>Exposes a simpler, uniform MonthDayInterval interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill MonthDayInterval business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class MonthDayIntervalBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public MonthDayIntervalBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * MonthDayInterval Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return MonthDayIntervalBusinessDelegate
   */
  public static MonthDayIntervalBusinessDelegate getMonthDayIntervalInstance() {
    return (new MonthDayIntervalBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createMonthDayInterval(CreateMonthDayIntervalCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getMonthDayIntervalId() == null) command.setMonthDayIntervalId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      MonthDayIntervalValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateMonthDayIntervalCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateMonthDayIntervalCommand of MonthDayInterval is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create MonthDayInterval - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateMonthDayIntervalCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateMonthDayInterval(UpdateMonthDayIntervalCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      MonthDayIntervalValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateMonthDayIntervalCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save MonthDayInterval - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteMonthDayIntervalCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteMonthDayIntervalCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      MonthDayIntervalValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteMonthDayIntervalCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete MonthDayInterval using Id = " + command.getMonthDayIntervalId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the MonthDayInterval via MonthDayIntervalFetchOneSummary
   *
   * @param summary MonthDayIntervalFetchOneSummary
   * @return MonthDayIntervalFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public MonthDayInterval getMonthDayInterval(MonthDayIntervalFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("MonthDayIntervalFetchOneSummary arg cannot be null");

    MonthDayInterval entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      MonthDayIntervalValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a MonthDayInterval
      // --------------------------------------
      CompletableFuture<MonthDayInterval> futureEntity =
          queryGateway.query(
              new FindMonthDayIntervalQuery(
                  new LoadMonthDayIntervalFilter(summary.getMonthDayIntervalId())),
              ResponseTypes.instanceOf(MonthDayInterval.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate MonthDayInterval with id " + summary.getMonthDayIntervalId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all MonthDayIntervals
   *
   * @return List<MonthDayInterval>
   * @exception ProcessingException Thrown if any problems
   */
  public List<MonthDayInterval> getAllMonthDayInterval() throws ProcessingException {
    List<MonthDayInterval> list = null;

    try {
      CompletableFuture<List<MonthDayInterval>> futureList =
          queryGateway.query(
              new FindAllMonthDayIntervalQuery(),
              ResponseTypes.multipleInstancesOf(MonthDayInterval.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all MonthDayInterval";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign End on MonthDayInterval
   *
   * @param command AssignEndToMonthDayIntervalCommand
   * @exception ProcessingException
   */
  public void assignEnd(AssignEndToMonthDayIntervalCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getMonthDayIntervalId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .MonthDayBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .MonthDayBusinessDelegate.getMonthDayInstance();
    MonthDayIntervalBusinessDelegate parentDelegate =
        MonthDayIntervalBusinessDelegate.getMonthDayIntervalInstance();
    UUID childId = command.getAssignment().getMonthDayId();
    MonthDay child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      MonthDayIntervalValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get MonthDay using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign End on MonthDayInterval
   *
   * @param command UnAssignEndFromMonthDayIntervalCommand
   * @exception ProcessingException
   */
  public void unAssignEnd(UnAssignEndFromMonthDayIntervalCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      MonthDayIntervalValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign End on MonthDayInterval";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Start on MonthDayInterval
   *
   * @param command AssignStartToMonthDayIntervalCommand
   * @exception ProcessingException
   */
  public void assignStart(AssignStartToMonthDayIntervalCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getMonthDayIntervalId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .MonthDayBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .MonthDayBusinessDelegate.getMonthDayInstance();
    MonthDayIntervalBusinessDelegate parentDelegate =
        MonthDayIntervalBusinessDelegate.getMonthDayIntervalInstance();
    UUID childId = command.getAssignment().getMonthDayId();
    MonthDay child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      MonthDayIntervalValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get MonthDay using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Start on MonthDayInterval
   *
   * @param command UnAssignStartFromMonthDayIntervalCommand
   * @exception ProcessingException
   */
  public void unAssignStart(UnAssignStartFromMonthDayIntervalCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      MonthDayIntervalValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Start on MonthDayInterval";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return MonthDayInterval
   */
  private MonthDayInterval load(UUID id) throws ProcessingException {
    monthDayInterval =
        MonthDayIntervalBusinessDelegate.getMonthDayIntervalInstance()
            .getMonthDayInterval(new MonthDayIntervalFetchOneSummary(id));
    return monthDayInterval;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private MonthDayInterval monthDayInterval = null;
  private static final Logger LOGGER =
      Logger.getLogger(MonthDayIntervalBusinessDelegate.class.getName());
}
