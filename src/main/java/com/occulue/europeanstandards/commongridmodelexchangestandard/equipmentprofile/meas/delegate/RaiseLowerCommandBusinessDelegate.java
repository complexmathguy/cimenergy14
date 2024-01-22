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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.validator.*;
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
 * RaiseLowerCommand business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of RaiseLowerCommand related services in the case of a
 *       RaiseLowerCommand business related service failing.
 *   <li>Exposes a simpler, uniform RaiseLowerCommand interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill RaiseLowerCommand business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class RaiseLowerCommandBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public RaiseLowerCommandBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * RaiseLowerCommand Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return RaiseLowerCommandBusinessDelegate
   */
  public static RaiseLowerCommandBusinessDelegate getRaiseLowerCommandInstance() {
    return (new RaiseLowerCommandBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createRaiseLowerCommand(CreateRaiseLowerCommandCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getRaiseLowerCommandId() == null)
        command.setRaiseLowerCommandId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      RaiseLowerCommandValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateRaiseLowerCommandCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateRaiseLowerCommandCommand of RaiseLowerCommand is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create RaiseLowerCommand - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateRaiseLowerCommandCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateRaiseLowerCommand(UpdateRaiseLowerCommandCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      RaiseLowerCommandValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateRaiseLowerCommandCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save RaiseLowerCommand - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteRaiseLowerCommandCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteRaiseLowerCommandCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      RaiseLowerCommandValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteRaiseLowerCommandCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete RaiseLowerCommand using Id = " + command.getRaiseLowerCommandId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the RaiseLowerCommand via RaiseLowerCommandFetchOneSummary
   *
   * @param summary RaiseLowerCommandFetchOneSummary
   * @return RaiseLowerCommandFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public RaiseLowerCommand getRaiseLowerCommand(RaiseLowerCommandFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("RaiseLowerCommandFetchOneSummary arg cannot be null");

    RaiseLowerCommand entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      RaiseLowerCommandValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a RaiseLowerCommand
      // --------------------------------------
      CompletableFuture<RaiseLowerCommand> futureEntity =
          queryGateway.query(
              new FindRaiseLowerCommandQuery(
                  new LoadRaiseLowerCommandFilter(summary.getRaiseLowerCommandId())),
              ResponseTypes.instanceOf(RaiseLowerCommand.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate RaiseLowerCommand with id " + summary.getRaiseLowerCommandId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all RaiseLowerCommands
   *
   * @return List<RaiseLowerCommand>
   * @exception ProcessingException Thrown if any problems
   */
  public List<RaiseLowerCommand> getAllRaiseLowerCommand() throws ProcessingException {
    List<RaiseLowerCommand> list = null;

    try {
      CompletableFuture<List<RaiseLowerCommand>> futureList =
          queryGateway.query(
              new FindAllRaiseLowerCommandQuery(),
              ResponseTypes.multipleInstancesOf(RaiseLowerCommand.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all RaiseLowerCommand";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * add RaiseLowerCommand to RaiseLowerCommands
   *
   * @param command AssignRaiseLowerCommandsToRaiseLowerCommandCommand
   * @exception ProcessingException
   */
  public void addToRaiseLowerCommands(AssignRaiseLowerCommandsToRaiseLowerCommandCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getRaiseLowerCommandId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.delegate
            .RaiseLowerCommandBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas
                .delegate.RaiseLowerCommandBusinessDelegate.getRaiseLowerCommandInstance();
    RaiseLowerCommandBusinessDelegate parentDelegate =
        RaiseLowerCommandBusinessDelegate.getRaiseLowerCommandInstance();
    UUID childId = command.getAddTo().getRaiseLowerCommandId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      RaiseLowerCommandValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg =
          "Failed to add a RaiseLowerCommand as RaiseLowerCommands to RaiseLowerCommand";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove RaiseLowerCommand from RaiseLowerCommands
   *
   * @param command RemoveRaiseLowerCommandsFromRaiseLowerCommandCommand
   * @exception ProcessingException
   */
  public void removeFromRaiseLowerCommands(
      RemoveRaiseLowerCommandsFromRaiseLowerCommandCommand command) throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.delegate
            .RaiseLowerCommandBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas
                .delegate.RaiseLowerCommandBusinessDelegate.getRaiseLowerCommandInstance();
    UUID childId = command.getRemoveFrom().getRaiseLowerCommandId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      RaiseLowerCommandValidator.getInstance().validate(command);

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
   * @return RaiseLowerCommand
   */
  private RaiseLowerCommand load(UUID id) throws ProcessingException {
    raiseLowerCommand =
        RaiseLowerCommandBusinessDelegate.getRaiseLowerCommandInstance()
            .getRaiseLowerCommand(new RaiseLowerCommandFetchOneSummary(id));
    return raiseLowerCommand;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private RaiseLowerCommand raiseLowerCommand = null;
  private static final Logger LOGGER =
      Logger.getLogger(RaiseLowerCommandBusinessDelegate.class.getName());
}
