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
 * LimitSet business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of LimitSet related services in the case of a LimitSet business
 *       related service failing.
 *   <li>Exposes a simpler, uniform LimitSet interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill LimitSet business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class LimitSetBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public LimitSetBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * LimitSet Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return LimitSetBusinessDelegate
   */
  public static LimitSetBusinessDelegate getLimitSetInstance() {
    return (new LimitSetBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createLimitSet(CreateLimitSetCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getLimitSetId() == null) command.setLimitSetId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      LimitSetValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateLimitSetCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateLimitSetCommand of LimitSet is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create LimitSet - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateLimitSetCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateLimitSet(UpdateLimitSetCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      LimitSetValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateLimitSetCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save LimitSet - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteLimitSetCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteLimitSetCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LimitSetValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteLimitSetCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete LimitSet using Id = " + command.getLimitSetId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the LimitSet via LimitSetFetchOneSummary
   *
   * @param summary LimitSetFetchOneSummary
   * @return LimitSetFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public LimitSet getLimitSet(LimitSetFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("LimitSetFetchOneSummary arg cannot be null");

    LimitSet entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      LimitSetValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a LimitSet
      // --------------------------------------
      CompletableFuture<LimitSet> futureEntity =
          queryGateway.query(
              new FindLimitSetQuery(new LoadLimitSetFilter(summary.getLimitSetId())),
              ResponseTypes.instanceOf(LimitSet.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate LimitSet with id " + summary.getLimitSetId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all LimitSets
   *
   * @return List<LimitSet>
   * @exception ProcessingException Thrown if any problems
   */
  public List<LimitSet> getAllLimitSet() throws ProcessingException {
    List<LimitSet> list = null;

    try {
      CompletableFuture<List<LimitSet>> futureList =
          queryGateway.query(
              new FindAllLimitSetQuery(), ResponseTypes.multipleInstancesOf(LimitSet.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all LimitSet";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign PercentageLimitsFlag on LimitSet
   *
   * @param command AssignPercentageLimitsFlagToLimitSetCommand
   * @exception ProcessingException
   */
  public void assignPercentageLimitsFlag(AssignPercentageLimitsFlagToLimitSetCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLimitSetId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    LimitSetBusinessDelegate parentDelegate = LimitSetBusinessDelegate.getLimitSetInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LimitSetValidator.getInstance().validate(command);

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
   * unAssign PercentageLimitsFlag on LimitSet
   *
   * @param command UnAssignPercentageLimitsFlagFromLimitSetCommand
   * @exception ProcessingException
   */
  public void unAssignPercentageLimitsFlag(UnAssignPercentageLimitsFlagFromLimitSetCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LimitSetValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign PercentageLimitsFlag on LimitSet";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return LimitSet
   */
  private LimitSet load(UUID id) throws ProcessingException {
    limitSet =
        LimitSetBusinessDelegate.getLimitSetInstance().getLimitSet(new LimitSetFetchOneSummary(id));
    return limitSet;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private LimitSet limitSet = null;
  private static final Logger LOGGER = Logger.getLogger(LimitSetBusinessDelegate.class.getName());
}
