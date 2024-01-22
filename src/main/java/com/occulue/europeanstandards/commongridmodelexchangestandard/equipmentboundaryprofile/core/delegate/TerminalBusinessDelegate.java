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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core.validator.*;
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
 * Terminal business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of Terminal related services in the case of a Terminal business
 *       related service failing.
 *   <li>Exposes a simpler, uniform Terminal interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill Terminal business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class TerminalBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public TerminalBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * Terminal Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return TerminalBusinessDelegate
   */
  public static TerminalBusinessDelegate getTerminalInstance() {
    return (new TerminalBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createTerminal(CreateTerminalCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getTerminalId() == null) command.setTerminalId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      TerminalValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateTerminalCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateTerminalCommand of Terminal is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create Terminal - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateTerminalCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateTerminal(UpdateTerminalCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      TerminalValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateTerminalCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save Terminal - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteTerminalCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteTerminalCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TerminalValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteTerminalCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete Terminal using Id = " + command.getTerminalId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the Terminal via TerminalFetchOneSummary
   *
   * @param summary TerminalFetchOneSummary
   * @return TerminalFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public Terminal getTerminal(TerminalFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("TerminalFetchOneSummary arg cannot be null");

    Terminal entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      TerminalValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a Terminal
      // --------------------------------------
      CompletableFuture<Terminal> futureEntity =
          queryGateway.query(
              new FindTerminalQuery(new LoadTerminalFilter(summary.getTerminalId())),
              ResponseTypes.instanceOf(Terminal.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate Terminal with id " + summary.getTerminalId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all Terminals
   *
   * @return List<Terminal>
   * @exception ProcessingException Thrown if any problems
   */
  public List<Terminal> getAllTerminal() throws ProcessingException {
    List<Terminal> list = null;

    try {
      CompletableFuture<List<Terminal>> futureList =
          queryGateway.query(
              new FindAllTerminalQuery(), ResponseTypes.multipleInstancesOf(Terminal.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all Terminal";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * add Terminal to Terminals
   *
   * @param command AssignTerminalsToTerminalCommand
   * @exception ProcessingException
   */
  public void addToTerminals(AssignTerminalsToTerminalCommand command) throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getTerminalId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core
            .delegate.TerminalBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile
                .core.delegate.TerminalBusinessDelegate.getTerminalInstance();
    TerminalBusinessDelegate parentDelegate = TerminalBusinessDelegate.getTerminalInstance();
    UUID childId = command.getAddTo().getTerminalId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TerminalValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a Terminal as Terminals to Terminal";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove Terminal from Terminals
   *
   * @param command RemoveTerminalsFromTerminalCommand
   * @exception ProcessingException
   */
  public void removeFromTerminals(RemoveTerminalsFromTerminalCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core
            .delegate.TerminalBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile
                .core.delegate.TerminalBusinessDelegate.getTerminalInstance();
    UUID childId = command.getRemoveFrom().getTerminalId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      TerminalValidator.getInstance().validate(command);

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
   * @return Terminal
   */
  private Terminal load(UUID id) throws ProcessingException {
    terminal =
        TerminalBusinessDelegate.getTerminalInstance().getTerminal(new TerminalFetchOneSummary(id));
    return terminal;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private Terminal terminal = null;
  private static final Logger LOGGER = Logger.getLogger(TerminalBusinessDelegate.class.getName());
}
