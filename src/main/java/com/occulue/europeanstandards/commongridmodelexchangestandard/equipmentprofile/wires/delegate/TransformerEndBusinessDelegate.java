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
 * TransformerEnd business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of TransformerEnd related services in the case of a TransformerEnd
 *       business related service failing.
 *   <li>Exposes a simpler, uniform TransformerEnd interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill TransformerEnd business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class TransformerEndBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public TransformerEndBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * TransformerEnd Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return TransformerEndBusinessDelegate
   */
  public static TransformerEndBusinessDelegate getTransformerEndInstance() {
    return (new TransformerEndBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createTransformerEnd(CreateTransformerEndCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getTransformerEndId() == null) command.setTransformerEndId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      TransformerEndValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateTransformerEndCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateTransformerEndCommand of TransformerEnd is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create TransformerEnd - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateTransformerEndCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateTransformerEnd(UpdateTransformerEndCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      TransformerEndValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateTransformerEndCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save TransformerEnd - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteTransformerEndCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteTransformerEndCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TransformerEndValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteTransformerEndCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete TransformerEnd using Id = " + command.getTransformerEndId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the TransformerEnd via TransformerEndFetchOneSummary
   *
   * @param summary TransformerEndFetchOneSummary
   * @return TransformerEndFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public TransformerEnd getTransformerEnd(TransformerEndFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("TransformerEndFetchOneSummary arg cannot be null");

    TransformerEnd entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      TransformerEndValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a TransformerEnd
      // --------------------------------------
      CompletableFuture<TransformerEnd> futureEntity =
          queryGateway.query(
              new FindTransformerEndQuery(
                  new LoadTransformerEndFilter(summary.getTransformerEndId())),
              ResponseTypes.instanceOf(TransformerEnd.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate TransformerEnd with id " + summary.getTransformerEndId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all TransformerEnds
   *
   * @return List<TransformerEnd>
   * @exception ProcessingException Thrown if any problems
   */
  public List<TransformerEnd> getAllTransformerEnd() throws ProcessingException {
    List<TransformerEnd> list = null;

    try {
      CompletableFuture<List<TransformerEnd>> futureList =
          queryGateway.query(
              new FindAllTransformerEndQuery(),
              ResponseTypes.multipleInstancesOf(TransformerEnd.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all TransformerEnd";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign EndNumber on TransformerEnd
   *
   * @param command AssignEndNumberToTransformerEndCommand
   * @exception ProcessingException
   */
  public void assignEndNumber(AssignEndNumberToTransformerEndCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTransformerEndId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .IntegerProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .IntegerProxyBusinessDelegate.getIntegerProxyInstance();
    TransformerEndBusinessDelegate parentDelegate =
        TransformerEndBusinessDelegate.getTransformerEndInstance();
    UUID childId = command.getAssignment().getIntegerProxyId();
    IntegerProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TransformerEndValidator.getInstance().validate(command);

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
   * unAssign EndNumber on TransformerEnd
   *
   * @param command UnAssignEndNumberFromTransformerEndCommand
   * @exception ProcessingException
   */
  public void unAssignEndNumber(UnAssignEndNumberFromTransformerEndCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TransformerEndValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign EndNumber on TransformerEnd";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Grounded on TransformerEnd
   *
   * @param command AssignGroundedToTransformerEndCommand
   * @exception ProcessingException
   */
  public void assignGrounded(AssignGroundedToTransformerEndCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTransformerEndId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    TransformerEndBusinessDelegate parentDelegate =
        TransformerEndBusinessDelegate.getTransformerEndInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TransformerEndValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get BooleanProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Grounded on TransformerEnd
   *
   * @param command UnAssignGroundedFromTransformerEndCommand
   * @exception ProcessingException
   */
  public void unAssignGrounded(UnAssignGroundedFromTransformerEndCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TransformerEndValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Grounded on TransformerEnd";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Rground on TransformerEnd
   *
   * @param command AssignRgroundToTransformerEndCommand
   * @exception ProcessingException
   */
  public void assignRground(AssignRgroundToTransformerEndCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTransformerEndId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ResistanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ResistanceBusinessDelegate.getResistanceInstance();
    TransformerEndBusinessDelegate parentDelegate =
        TransformerEndBusinessDelegate.getTransformerEndInstance();
    UUID childId = command.getAssignment().getResistanceId();
    Resistance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TransformerEndValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Resistance using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Rground on TransformerEnd
   *
   * @param command UnAssignRgroundFromTransformerEndCommand
   * @exception ProcessingException
   */
  public void unAssignRground(UnAssignRgroundFromTransformerEndCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TransformerEndValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Rground on TransformerEnd";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Xground on TransformerEnd
   *
   * @param command AssignXgroundToTransformerEndCommand
   * @exception ProcessingException
   */
  public void assignXground(AssignXgroundToTransformerEndCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTransformerEndId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ReactanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ReactanceBusinessDelegate.getReactanceInstance();
    TransformerEndBusinessDelegate parentDelegate =
        TransformerEndBusinessDelegate.getTransformerEndInstance();
    UUID childId = command.getAssignment().getReactanceId();
    Reactance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TransformerEndValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Reactance using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Xground on TransformerEnd
   *
   * @param command UnAssignXgroundFromTransformerEndCommand
   * @exception ProcessingException
   */
  public void unAssignXground(UnAssignXgroundFromTransformerEndCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TransformerEndValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Xground on TransformerEnd";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * add TransformerEnd to TransformerEnds
   *
   * @param command AssignTransformerEndsToTransformerEndCommand
   * @exception ProcessingException
   */
  public void addToTransformerEnds(AssignTransformerEndsToTransformerEndCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getTransformerEndId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate
            .TransformerEndBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
                .delegate.TransformerEndBusinessDelegate.getTransformerEndInstance();
    TransformerEndBusinessDelegate parentDelegate =
        TransformerEndBusinessDelegate.getTransformerEndInstance();
    UUID childId = command.getAddTo().getTransformerEndId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TransformerEndValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a TransformerEnd as TransformerEnds to TransformerEnd";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove TransformerEnd from TransformerEnds
   *
   * @param command RemoveTransformerEndsFromTransformerEndCommand
   * @exception ProcessingException
   */
  public void removeFromTransformerEnds(RemoveTransformerEndsFromTransformerEndCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate
            .TransformerEndBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
                .delegate.TransformerEndBusinessDelegate.getTransformerEndInstance();
    UUID childId = command.getRemoveFrom().getTransformerEndId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      TransformerEndValidator.getInstance().validate(command);

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
   * add TransformerEnd to TransformerEnd
   *
   * @param command AssignTransformerEndToTransformerEndCommand
   * @exception ProcessingException
   */
  public void addToTransformerEnd(AssignTransformerEndToTransformerEndCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getTransformerEndId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate
            .TransformerEndBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
                .delegate.TransformerEndBusinessDelegate.getTransformerEndInstance();
    TransformerEndBusinessDelegate parentDelegate =
        TransformerEndBusinessDelegate.getTransformerEndInstance();
    UUID childId = command.getAddTo().getTransformerEndId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TransformerEndValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a TransformerEnd as TransformerEnd to TransformerEnd";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove TransformerEnd from TransformerEnd
   *
   * @param command RemoveTransformerEndFromTransformerEndCommand
   * @exception ProcessingException
   */
  public void removeFromTransformerEnd(RemoveTransformerEndFromTransformerEndCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate
            .TransformerEndBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
                .delegate.TransformerEndBusinessDelegate.getTransformerEndInstance();
    UUID childId = command.getRemoveFrom().getTransformerEndId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      TransformerEndValidator.getInstance().validate(command);

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
   * @return TransformerEnd
   */
  private TransformerEnd load(UUID id) throws ProcessingException {
    transformerEnd =
        TransformerEndBusinessDelegate.getTransformerEndInstance()
            .getTransformerEnd(new TransformerEndFetchOneSummary(id));
    return transformerEnd;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private TransformerEnd transformerEnd = null;
  private static final Logger LOGGER =
      Logger.getLogger(TransformerEndBusinessDelegate.class.getName());
}
