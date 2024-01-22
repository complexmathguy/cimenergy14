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
 * Command business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of Command related services in the case of a Command business
 *       related service failing.
 *   <li>Exposes a simpler, uniform Command interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill Command business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class CommandBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public CommandBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * Command Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return CommandBusinessDelegate
   */
  public static CommandBusinessDelegate getCommandInstance() {
    return (new CommandBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createCommand(CreateCommandCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getCommandId() == null) command.setCommandId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      CommandValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateCommandCommand - by convention the future return value for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateCommandCommand of Command is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create Command - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateCommandCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateCommand(UpdateCommandCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      CommandValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateCommandCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save Command - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteCommandCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteCommandCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      CommandValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteCommandCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete Command using Id = " + command.getCommandId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the Command via CommandFetchOneSummary
   *
   * @param summary CommandFetchOneSummary
   * @return CommandFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public Command getCommand(CommandFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("CommandFetchOneSummary arg cannot be null");

    Command entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      CommandValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a Command
      // --------------------------------------
      CompletableFuture<Command> futureEntity =
          queryGateway.query(
              new FindCommandQuery(new LoadCommandFilter(summary.getCommandId())),
              ResponseTypes.instanceOf(Command.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate Command with id " + summary.getCommandId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all Commands
   *
   * @return List<Command>
   * @exception ProcessingException Thrown if any problems
   */
  public List<Command> getAllCommand() throws ProcessingException {
    List<Command> list = null;

    try {
      CompletableFuture<List<Command>> futureList =
          queryGateway.query(
              new FindAllCommandQuery(), ResponseTypes.multipleInstancesOf(Command.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all Command";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign NormalValue on Command
   *
   * @param command AssignNormalValueToCommandCommand
   * @exception ProcessingException
   */
  public void assignNormalValue(AssignNormalValueToCommandCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getCommandId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .IntegerProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .IntegerProxyBusinessDelegate.getIntegerProxyInstance();
    CommandBusinessDelegate parentDelegate = CommandBusinessDelegate.getCommandInstance();
    UUID childId = command.getAssignment().getIntegerProxyId();
    IntegerProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      CommandValidator.getInstance().validate(command);

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
   * unAssign NormalValue on Command
   *
   * @param command UnAssignNormalValueFromCommandCommand
   * @exception ProcessingException
   */
  public void unAssignNormalValue(UnAssignNormalValueFromCommandCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      CommandValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign NormalValue on Command";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Value on Command
   *
   * @param command AssignValueToCommandCommand
   * @exception ProcessingException
   */
  public void assignValue(AssignValueToCommandCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getCommandId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .IntegerProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .IntegerProxyBusinessDelegate.getIntegerProxyInstance();
    CommandBusinessDelegate parentDelegate = CommandBusinessDelegate.getCommandInstance();
    UUID childId = command.getAssignment().getIntegerProxyId();
    IntegerProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      CommandValidator.getInstance().validate(command);

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
   * unAssign Value on Command
   *
   * @param command UnAssignValueFromCommandCommand
   * @exception ProcessingException
   */
  public void unAssignValue(UnAssignValueFromCommandCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      CommandValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Value on Command";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Command on Command
   *
   * @param command AssignCommandToCommandCommand
   * @exception ProcessingException
   */
  public void assignCommand(AssignCommandToCommandCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getCommandId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.delegate
            .CommandBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas
                .delegate.CommandBusinessDelegate.getCommandInstance();
    CommandBusinessDelegate parentDelegate = CommandBusinessDelegate.getCommandInstance();
    UUID childId = command.getAssignment().getCommandId();
    Command child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      CommandValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Command using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Command on Command
   *
   * @param command UnAssignCommandFromCommandCommand
   * @exception ProcessingException
   */
  public void unAssignCommand(UnAssignCommandFromCommandCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      CommandValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Command on Command";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * add Command to Commands
   *
   * @param command AssignCommandsToCommandCommand
   * @exception ProcessingException
   */
  public void addToCommands(AssignCommandsToCommandCommand command) throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getCommandId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.delegate
            .CommandBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas
                .delegate.CommandBusinessDelegate.getCommandInstance();
    CommandBusinessDelegate parentDelegate = CommandBusinessDelegate.getCommandInstance();
    UUID childId = command.getAddTo().getCommandId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      CommandValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a Command as Commands to Command";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove Command from Commands
   *
   * @param command RemoveCommandsFromCommandCommand
   * @exception ProcessingException
   */
  public void removeFromCommands(RemoveCommandsFromCommandCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.delegate
            .CommandBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas
                .delegate.CommandBusinessDelegate.getCommandInstance();
    UUID childId = command.getRemoveFrom().getCommandId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      CommandValidator.getInstance().validate(command);

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
   * @return Command
   */
  private Command load(UUID id) throws ProcessingException {
    command =
        CommandBusinessDelegate.getCommandInstance().getCommand(new CommandFetchOneSummary(id));
    return command;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private Command command = null;
  private static final Logger LOGGER = Logger.getLogger(CommandBusinessDelegate.class.getName());
}
