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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.validator.*;
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
 * DCBaseTerminal business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of DCBaseTerminal related services in the case of a DCBaseTerminal
 *       business related service failing.
 *   <li>Exposes a simpler, uniform DCBaseTerminal interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill DCBaseTerminal business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class DCBaseTerminalBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public DCBaseTerminalBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * DCBaseTerminal Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return DCBaseTerminalBusinessDelegate
   */
  public static DCBaseTerminalBusinessDelegate getDCBaseTerminalInstance() {
    return (new DCBaseTerminalBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createDCBaseTerminal(CreateDCBaseTerminalCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getDCBaseTerminalId() == null) command.setDCBaseTerminalId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      DCBaseTerminalValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateDCBaseTerminalCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateDCBaseTerminalCommand of DCBaseTerminal is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create DCBaseTerminal - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateDCBaseTerminalCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateDCBaseTerminal(UpdateDCBaseTerminalCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      DCBaseTerminalValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateDCBaseTerminalCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save DCBaseTerminal - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteDCBaseTerminalCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteDCBaseTerminalCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DCBaseTerminalValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteDCBaseTerminalCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete DCBaseTerminal using Id = " + command.getDCBaseTerminalId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the DCBaseTerminal via DCBaseTerminalFetchOneSummary
   *
   * @param summary DCBaseTerminalFetchOneSummary
   * @return DCBaseTerminalFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public DCBaseTerminal getDCBaseTerminal(DCBaseTerminalFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("DCBaseTerminalFetchOneSummary arg cannot be null");

    DCBaseTerminal entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      DCBaseTerminalValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a DCBaseTerminal
      // --------------------------------------
      CompletableFuture<DCBaseTerminal> futureEntity =
          queryGateway.query(
              new FindDCBaseTerminalQuery(
                  new LoadDCBaseTerminalFilter(summary.getDCBaseTerminalId())),
              ResponseTypes.instanceOf(DCBaseTerminal.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate DCBaseTerminal with id " + summary.getDCBaseTerminalId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all DCBaseTerminals
   *
   * @return List<DCBaseTerminal>
   * @exception ProcessingException Thrown if any problems
   */
  public List<DCBaseTerminal> getAllDCBaseTerminal() throws ProcessingException {
    List<DCBaseTerminal> list = null;

    try {
      CompletableFuture<List<DCBaseTerminal>> futureList =
          queryGateway.query(
              new FindAllDCBaseTerminalQuery(),
              ResponseTypes.multipleInstancesOf(DCBaseTerminal.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all DCBaseTerminal";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * add DCBaseTerminal to DCTerminals
   *
   * @param command AssignDCTerminalsToDCBaseTerminalCommand
   * @exception ProcessingException
   */
  public void addToDCTerminals(AssignDCTerminalsToDCBaseTerminalCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getDCBaseTerminalId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.delegate
            .DCBaseTerminalBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc
                .delegate.DCBaseTerminalBusinessDelegate.getDCBaseTerminalInstance();
    DCBaseTerminalBusinessDelegate parentDelegate =
        DCBaseTerminalBusinessDelegate.getDCBaseTerminalInstance();
    UUID childId = command.getAddTo().getDCBaseTerminalId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DCBaseTerminalValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a DCBaseTerminal as DCTerminals to DCBaseTerminal";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove DCBaseTerminal from DCTerminals
   *
   * @param command RemoveDCTerminalsFromDCBaseTerminalCommand
   * @exception ProcessingException
   */
  public void removeFromDCTerminals(RemoveDCTerminalsFromDCBaseTerminalCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.delegate
            .DCBaseTerminalBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc
                .delegate.DCBaseTerminalBusinessDelegate.getDCBaseTerminalInstance();
    UUID childId = command.getRemoveFrom().getDCBaseTerminalId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      DCBaseTerminalValidator.getInstance().validate(command);

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
   * @return DCBaseTerminal
   */
  private DCBaseTerminal load(UUID id) throws ProcessingException {
    dCBaseTerminal =
        DCBaseTerminalBusinessDelegate.getDCBaseTerminalInstance()
            .getDCBaseTerminal(new DCBaseTerminalFetchOneSummary(id));
    return dCBaseTerminal;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private DCBaseTerminal dCBaseTerminal = null;
  private static final Logger LOGGER =
      Logger.getLogger(DCBaseTerminalBusinessDelegate.class.getName());
}
