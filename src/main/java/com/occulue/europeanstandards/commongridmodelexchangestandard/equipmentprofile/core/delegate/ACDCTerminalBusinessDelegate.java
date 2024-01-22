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
 * ACDCTerminal business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of ACDCTerminal related services in the case of a ACDCTerminal
 *       business related service failing.
 *   <li>Exposes a simpler, uniform ACDCTerminal interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill ACDCTerminal business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class ACDCTerminalBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public ACDCTerminalBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * ACDCTerminal Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return ACDCTerminalBusinessDelegate
   */
  public static ACDCTerminalBusinessDelegate getACDCTerminalInstance() {
    return (new ACDCTerminalBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createACDCTerminal(CreateACDCTerminalCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getACDCTerminalId() == null) command.setACDCTerminalId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      ACDCTerminalValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateACDCTerminalCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateACDCTerminalCommand of ACDCTerminal is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create ACDCTerminal - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateACDCTerminalCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateACDCTerminal(UpdateACDCTerminalCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      ACDCTerminalValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateACDCTerminalCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save ACDCTerminal - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteACDCTerminalCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteACDCTerminalCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ACDCTerminalValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteACDCTerminalCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete ACDCTerminal using Id = " + command.getACDCTerminalId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the ACDCTerminal via ACDCTerminalFetchOneSummary
   *
   * @param summary ACDCTerminalFetchOneSummary
   * @return ACDCTerminalFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public ACDCTerminal getACDCTerminal(ACDCTerminalFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("ACDCTerminalFetchOneSummary arg cannot be null");

    ACDCTerminal entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      ACDCTerminalValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a ACDCTerminal
      // --------------------------------------
      CompletableFuture<ACDCTerminal> futureEntity =
          queryGateway.query(
              new FindACDCTerminalQuery(new LoadACDCTerminalFilter(summary.getACDCTerminalId())),
              ResponseTypes.instanceOf(ACDCTerminal.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate ACDCTerminal with id " + summary.getACDCTerminalId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all ACDCTerminals
   *
   * @return List<ACDCTerminal>
   * @exception ProcessingException Thrown if any problems
   */
  public List<ACDCTerminal> getAllACDCTerminal() throws ProcessingException {
    List<ACDCTerminal> list = null;

    try {
      CompletableFuture<List<ACDCTerminal>> futureList =
          queryGateway.query(
              new FindAllACDCTerminalQuery(),
              ResponseTypes.multipleInstancesOf(ACDCTerminal.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all ACDCTerminal";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign SequenceNumber on ACDCTerminal
   *
   * @param command AssignSequenceNumberToACDCTerminalCommand
   * @exception ProcessingException
   */
  public void assignSequenceNumber(AssignSequenceNumberToACDCTerminalCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getACDCTerminalId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .IntegerProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .IntegerProxyBusinessDelegate.getIntegerProxyInstance();
    ACDCTerminalBusinessDelegate parentDelegate =
        ACDCTerminalBusinessDelegate.getACDCTerminalInstance();
    UUID childId = command.getAssignment().getIntegerProxyId();
    IntegerProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ACDCTerminalValidator.getInstance().validate(command);

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
   * unAssign SequenceNumber on ACDCTerminal
   *
   * @param command UnAssignSequenceNumberFromACDCTerminalCommand
   * @exception ProcessingException
   */
  public void unAssignSequenceNumber(UnAssignSequenceNumberFromACDCTerminalCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ACDCTerminalValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign SequenceNumber on ACDCTerminal";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * add ACDCTerminal to Terminal
   *
   * @param command AssignTerminalToACDCTerminalCommand
   * @exception ProcessingException
   */
  public void addToTerminal(AssignTerminalToACDCTerminalCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getACDCTerminalId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.delegate
            .ACDCTerminalBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core
                .delegate.ACDCTerminalBusinessDelegate.getACDCTerminalInstance();
    ACDCTerminalBusinessDelegate parentDelegate =
        ACDCTerminalBusinessDelegate.getACDCTerminalInstance();
    UUID childId = command.getAddTo().getACDCTerminalId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ACDCTerminalValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a ACDCTerminal as Terminal to ACDCTerminal";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove ACDCTerminal from Terminal
   *
   * @param command RemoveTerminalFromACDCTerminalCommand
   * @exception ProcessingException
   */
  public void removeFromTerminal(RemoveTerminalFromACDCTerminalCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.delegate
            .ACDCTerminalBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core
                .delegate.ACDCTerminalBusinessDelegate.getACDCTerminalInstance();
    UUID childId = command.getRemoveFrom().getACDCTerminalId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      ACDCTerminalValidator.getInstance().validate(command);

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
   * @return ACDCTerminal
   */
  private ACDCTerminal load(UUID id) throws ProcessingException {
    aCDCTerminal =
        ACDCTerminalBusinessDelegate.getACDCTerminalInstance()
            .getACDCTerminal(new ACDCTerminalFetchOneSummary(id));
    return aCDCTerminal;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private ACDCTerminal aCDCTerminal = null;
  private static final Logger LOGGER =
      Logger.getLogger(ACDCTerminalBusinessDelegate.class.getName());
}
