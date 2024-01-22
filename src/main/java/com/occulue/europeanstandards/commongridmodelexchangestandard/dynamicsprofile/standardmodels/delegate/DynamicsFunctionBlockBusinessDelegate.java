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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.validator.*;
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
 * DynamicsFunctionBlock business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of DynamicsFunctionBlock related services in the case of a
 *       DynamicsFunctionBlock business related service failing.
 *   <li>Exposes a simpler, uniform DynamicsFunctionBlock interface to the business tier, making it
 *       easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill DynamicsFunctionBlock
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class DynamicsFunctionBlockBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public DynamicsFunctionBlockBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * DynamicsFunctionBlock Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return DynamicsFunctionBlockBusinessDelegate
   */
  public static DynamicsFunctionBlockBusinessDelegate getDynamicsFunctionBlockInstance() {
    return (new DynamicsFunctionBlockBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createDynamicsFunctionBlock(
      CreateDynamicsFunctionBlockCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getDynamicsFunctionBlockId() == null)
        command.setDynamicsFunctionBlockId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      DynamicsFunctionBlockValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateDynamicsFunctionBlockCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateDynamicsFunctionBlockCommand of DynamicsFunctionBlock is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create DynamicsFunctionBlock - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateDynamicsFunctionBlockCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateDynamicsFunctionBlock(
      UpdateDynamicsFunctionBlockCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      DynamicsFunctionBlockValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateDynamicsFunctionBlockCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save DynamicsFunctionBlock - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteDynamicsFunctionBlockCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteDynamicsFunctionBlockCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DynamicsFunctionBlockValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteDynamicsFunctionBlockCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete DynamicsFunctionBlock using Id = "
              + command.getDynamicsFunctionBlockId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the DynamicsFunctionBlock via DynamicsFunctionBlockFetchOneSummary
   *
   * @param summary DynamicsFunctionBlockFetchOneSummary
   * @return DynamicsFunctionBlockFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public DynamicsFunctionBlock getDynamicsFunctionBlock(
      DynamicsFunctionBlockFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("DynamicsFunctionBlockFetchOneSummary arg cannot be null");

    DynamicsFunctionBlock entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      DynamicsFunctionBlockValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a DynamicsFunctionBlock
      // --------------------------------------
      CompletableFuture<DynamicsFunctionBlock> futureEntity =
          queryGateway.query(
              new FindDynamicsFunctionBlockQuery(
                  new LoadDynamicsFunctionBlockFilter(summary.getDynamicsFunctionBlockId())),
              ResponseTypes.instanceOf(DynamicsFunctionBlock.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate DynamicsFunctionBlock with id " + summary.getDynamicsFunctionBlockId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all DynamicsFunctionBlocks
   *
   * @return List<DynamicsFunctionBlock>
   * @exception ProcessingException Thrown if any problems
   */
  public List<DynamicsFunctionBlock> getAllDynamicsFunctionBlock() throws ProcessingException {
    List<DynamicsFunctionBlock> list = null;

    try {
      CompletableFuture<List<DynamicsFunctionBlock>> futureList =
          queryGateway.query(
              new FindAllDynamicsFunctionBlockQuery(),
              ResponseTypes.multipleInstancesOf(DynamicsFunctionBlock.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all DynamicsFunctionBlock";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Enabled on DynamicsFunctionBlock
   *
   * @param command AssignEnabledToDynamicsFunctionBlockCommand
   * @exception ProcessingException
   */
  public void assignEnabled(AssignEnabledToDynamicsFunctionBlockCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDynamicsFunctionBlockId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    DynamicsFunctionBlockBusinessDelegate parentDelegate =
        DynamicsFunctionBlockBusinessDelegate.getDynamicsFunctionBlockInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DynamicsFunctionBlockValidator.getInstance().validate(command);

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
   * unAssign Enabled on DynamicsFunctionBlock
   *
   * @param command UnAssignEnabledFromDynamicsFunctionBlockCommand
   * @exception ProcessingException
   */
  public void unAssignEnabled(UnAssignEnabledFromDynamicsFunctionBlockCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DynamicsFunctionBlockValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Enabled on DynamicsFunctionBlock";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return DynamicsFunctionBlock
   */
  private DynamicsFunctionBlock load(UUID id) throws ProcessingException {
    dynamicsFunctionBlock =
        DynamicsFunctionBlockBusinessDelegate.getDynamicsFunctionBlockInstance()
            .getDynamicsFunctionBlock(new DynamicsFunctionBlockFetchOneSummary(id));
    return dynamicsFunctionBlock;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private DynamicsFunctionBlock dynamicsFunctionBlock = null;
  private static final Logger LOGGER =
      Logger.getLogger(DynamicsFunctionBlockBusinessDelegate.class.getName());
}
