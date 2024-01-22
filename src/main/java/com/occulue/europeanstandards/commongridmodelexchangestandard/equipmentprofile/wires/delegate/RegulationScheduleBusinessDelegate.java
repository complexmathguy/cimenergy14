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
 * RegulationSchedule business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of RegulationSchedule related services in the case of a
 *       RegulationSchedule business related service failing.
 *   <li>Exposes a simpler, uniform RegulationSchedule interface to the business tier, making it
 *       easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill RegulationSchedule
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class RegulationScheduleBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public RegulationScheduleBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * RegulationSchedule Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return RegulationScheduleBusinessDelegate
   */
  public static RegulationScheduleBusinessDelegate getRegulationScheduleInstance() {
    return (new RegulationScheduleBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createRegulationSchedule(CreateRegulationScheduleCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getRegulationScheduleId() == null)
        command.setRegulationScheduleId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      RegulationScheduleValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateRegulationScheduleCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateRegulationScheduleCommand of RegulationSchedule is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create RegulationSchedule - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateRegulationScheduleCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateRegulationSchedule(UpdateRegulationScheduleCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      RegulationScheduleValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateRegulationScheduleCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save RegulationSchedule - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteRegulationScheduleCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteRegulationScheduleCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      RegulationScheduleValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteRegulationScheduleCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete RegulationSchedule using Id = " + command.getRegulationScheduleId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the RegulationSchedule via RegulationScheduleFetchOneSummary
   *
   * @param summary RegulationScheduleFetchOneSummary
   * @return RegulationScheduleFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public RegulationSchedule getRegulationSchedule(RegulationScheduleFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("RegulationScheduleFetchOneSummary arg cannot be null");

    RegulationSchedule entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      RegulationScheduleValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a RegulationSchedule
      // --------------------------------------
      CompletableFuture<RegulationSchedule> futureEntity =
          queryGateway.query(
              new FindRegulationScheduleQuery(
                  new LoadRegulationScheduleFilter(summary.getRegulationScheduleId())),
              ResponseTypes.instanceOf(RegulationSchedule.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate RegulationSchedule with id " + summary.getRegulationScheduleId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all RegulationSchedules
   *
   * @return List<RegulationSchedule>
   * @exception ProcessingException Thrown if any problems
   */
  public List<RegulationSchedule> getAllRegulationSchedule() throws ProcessingException {
    List<RegulationSchedule> list = null;

    try {
      CompletableFuture<List<RegulationSchedule>> futureList =
          queryGateway.query(
              new FindAllRegulationScheduleQuery(),
              ResponseTypes.multipleInstancesOf(RegulationSchedule.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all RegulationSchedule";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * add RegulationSchedule to RegulationSchedule
   *
   * @param command AssignRegulationScheduleToRegulationScheduleCommand
   * @exception ProcessingException
   */
  public void addToRegulationSchedule(AssignRegulationScheduleToRegulationScheduleCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getRegulationScheduleId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate
            .RegulationScheduleBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
                .delegate.RegulationScheduleBusinessDelegate.getRegulationScheduleInstance();
    RegulationScheduleBusinessDelegate parentDelegate =
        RegulationScheduleBusinessDelegate.getRegulationScheduleInstance();
    UUID childId = command.getAddTo().getRegulationScheduleId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      RegulationScheduleValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg =
          "Failed to add a RegulationSchedule as RegulationSchedule to RegulationSchedule";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove RegulationSchedule from RegulationSchedule
   *
   * @param command RemoveRegulationScheduleFromRegulationScheduleCommand
   * @exception ProcessingException
   */
  public void removeFromRegulationSchedule(
      RemoveRegulationScheduleFromRegulationScheduleCommand command) throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate
            .RegulationScheduleBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
                .delegate.RegulationScheduleBusinessDelegate.getRegulationScheduleInstance();
    UUID childId = command.getRemoveFrom().getRegulationScheduleId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      RegulationScheduleValidator.getInstance().validate(command);

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
   * @return RegulationSchedule
   */
  private RegulationSchedule load(UUID id) throws ProcessingException {
    regulationSchedule =
        RegulationScheduleBusinessDelegate.getRegulationScheduleInstance()
            .getRegulationSchedule(new RegulationScheduleFetchOneSummary(id));
    return regulationSchedule;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private RegulationSchedule regulationSchedule = null;
  private static final Logger LOGGER =
      Logger.getLogger(RegulationScheduleBusinessDelegate.class.getName());
}
