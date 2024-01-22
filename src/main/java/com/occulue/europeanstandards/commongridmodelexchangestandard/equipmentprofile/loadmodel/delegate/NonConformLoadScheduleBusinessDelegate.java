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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.validator.*;
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
 * NonConformLoadSchedule business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of NonConformLoadSchedule related services in the case of a
 *       NonConformLoadSchedule business related service failing.
 *   <li>Exposes a simpler, uniform NonConformLoadSchedule interface to the business tier, making it
 *       easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill NonConformLoadSchedule
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class NonConformLoadScheduleBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public NonConformLoadScheduleBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * NonConformLoadSchedule Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return NonConformLoadScheduleBusinessDelegate
   */
  public static NonConformLoadScheduleBusinessDelegate getNonConformLoadScheduleInstance() {
    return (new NonConformLoadScheduleBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createNonConformLoadSchedule(
      CreateNonConformLoadScheduleCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getNonConformLoadScheduleId() == null)
        command.setNonConformLoadScheduleId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      NonConformLoadScheduleValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateNonConformLoadScheduleCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateNonConformLoadScheduleCommand of NonConformLoadSchedule is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create NonConformLoadSchedule - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateNonConformLoadScheduleCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateNonConformLoadSchedule(
      UpdateNonConformLoadScheduleCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      NonConformLoadScheduleValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateNonConformLoadScheduleCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save NonConformLoadSchedule - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteNonConformLoadScheduleCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteNonConformLoadScheduleCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      NonConformLoadScheduleValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteNonConformLoadScheduleCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete NonConformLoadSchedule using Id = "
              + command.getNonConformLoadScheduleId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the NonConformLoadSchedule via NonConformLoadScheduleFetchOneSummary
   *
   * @param summary NonConformLoadScheduleFetchOneSummary
   * @return NonConformLoadScheduleFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public NonConformLoadSchedule getNonConformLoadSchedule(
      NonConformLoadScheduleFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "NonConformLoadScheduleFetchOneSummary arg cannot be null");

    NonConformLoadSchedule entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      NonConformLoadScheduleValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a NonConformLoadSchedule
      // --------------------------------------
      CompletableFuture<NonConformLoadSchedule> futureEntity =
          queryGateway.query(
              new FindNonConformLoadScheduleQuery(
                  new LoadNonConformLoadScheduleFilter(summary.getNonConformLoadScheduleId())),
              ResponseTypes.instanceOf(NonConformLoadSchedule.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate NonConformLoadSchedule with id "
              + summary.getNonConformLoadScheduleId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all NonConformLoadSchedules
   *
   * @return List<NonConformLoadSchedule>
   * @exception ProcessingException Thrown if any problems
   */
  public List<NonConformLoadSchedule> getAllNonConformLoadSchedule() throws ProcessingException {
    List<NonConformLoadSchedule> list = null;

    try {
      CompletableFuture<List<NonConformLoadSchedule>> futureList =
          queryGateway.query(
              new FindAllNonConformLoadScheduleQuery(),
              ResponseTypes.multipleInstancesOf(NonConformLoadSchedule.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all NonConformLoadSchedule";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * add NonConformLoadSchedule to NonConformLoadSchedules
   *
   * @param command AssignNonConformLoadSchedulesToNonConformLoadScheduleCommand
   * @exception ProcessingException
   */
  public void addToNonConformLoadSchedules(
      AssignNonConformLoadSchedulesToNonConformLoadScheduleCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getNonConformLoadScheduleId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel
            .delegate.NonConformLoadScheduleBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel
                .delegate.NonConformLoadScheduleBusinessDelegate
                .getNonConformLoadScheduleInstance();
    NonConformLoadScheduleBusinessDelegate parentDelegate =
        NonConformLoadScheduleBusinessDelegate.getNonConformLoadScheduleInstance();
    UUID childId = command.getAddTo().getNonConformLoadScheduleId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      NonConformLoadScheduleValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg =
          "Failed to add a NonConformLoadSchedule as NonConformLoadSchedules to NonConformLoadSchedule";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove NonConformLoadSchedule from NonConformLoadSchedules
   *
   * @param command RemoveNonConformLoadSchedulesFromNonConformLoadScheduleCommand
   * @exception ProcessingException
   */
  public void removeFromNonConformLoadSchedules(
      RemoveNonConformLoadSchedulesFromNonConformLoadScheduleCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel
            .delegate.NonConformLoadScheduleBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel
                .delegate.NonConformLoadScheduleBusinessDelegate
                .getNonConformLoadScheduleInstance();
    UUID childId = command.getRemoveFrom().getNonConformLoadScheduleId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      NonConformLoadScheduleValidator.getInstance().validate(command);

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
   * @return NonConformLoadSchedule
   */
  private NonConformLoadSchedule load(UUID id) throws ProcessingException {
    nonConformLoadSchedule =
        NonConformLoadScheduleBusinessDelegate.getNonConformLoadScheduleInstance()
            .getNonConformLoadSchedule(new NonConformLoadScheduleFetchOneSummary(id));
    return nonConformLoadSchedule;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private NonConformLoadSchedule nonConformLoadSchedule = null;
  private static final Logger LOGGER =
      Logger.getLogger(NonConformLoadScheduleBusinessDelegate.class.getName());
}
