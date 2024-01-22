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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.operationallimits.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.operationallimits.validator.*;
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
 * ApparentPowerLimit business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of ApparentPowerLimit related services in the case of a
 *       ApparentPowerLimit business related service failing.
 *   <li>Exposes a simpler, uniform ApparentPowerLimit interface to the business tier, making it
 *       easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill ApparentPowerLimit
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class ApparentPowerLimitBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public ApparentPowerLimitBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * ApparentPowerLimit Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return ApparentPowerLimitBusinessDelegate
   */
  public static ApparentPowerLimitBusinessDelegate getApparentPowerLimitInstance() {
    return (new ApparentPowerLimitBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createApparentPowerLimit(CreateApparentPowerLimitCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getApparentPowerLimitId() == null)
        command.setApparentPowerLimitId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      ApparentPowerLimitValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateApparentPowerLimitCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateApparentPowerLimitCommand of ApparentPowerLimit is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create ApparentPowerLimit - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateApparentPowerLimitCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateApparentPowerLimit(UpdateApparentPowerLimitCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      ApparentPowerLimitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateApparentPowerLimitCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save ApparentPowerLimit - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteApparentPowerLimitCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteApparentPowerLimitCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ApparentPowerLimitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteApparentPowerLimitCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete ApparentPowerLimit using Id = " + command.getApparentPowerLimitId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the ApparentPowerLimit via ApparentPowerLimitFetchOneSummary
   *
   * @param summary ApparentPowerLimitFetchOneSummary
   * @return ApparentPowerLimitFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public ApparentPowerLimit getApparentPowerLimit(ApparentPowerLimitFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("ApparentPowerLimitFetchOneSummary arg cannot be null");

    ApparentPowerLimit entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      ApparentPowerLimitValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a ApparentPowerLimit
      // --------------------------------------
      CompletableFuture<ApparentPowerLimit> futureEntity =
          queryGateway.query(
              new FindApparentPowerLimitQuery(
                  new LoadApparentPowerLimitFilter(summary.getApparentPowerLimitId())),
              ResponseTypes.instanceOf(ApparentPowerLimit.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate ApparentPowerLimit with id " + summary.getApparentPowerLimitId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all ApparentPowerLimits
   *
   * @return List<ApparentPowerLimit>
   * @exception ProcessingException Thrown if any problems
   */
  public List<ApparentPowerLimit> getAllApparentPowerLimit() throws ProcessingException {
    List<ApparentPowerLimit> list = null;

    try {
      CompletableFuture<List<ApparentPowerLimit>> futureList =
          queryGateway.query(
              new FindAllApparentPowerLimitQuery(),
              ResponseTypes.multipleInstancesOf(ApparentPowerLimit.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all ApparentPowerLimit";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Value on ApparentPowerLimit
   *
   * @param command AssignValueToApparentPowerLimitCommand
   * @exception ProcessingException
   */
  public void assignValue(AssignValueToApparentPowerLimitCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getApparentPowerLimitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ApparentPowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ApparentPowerBusinessDelegate.getApparentPowerInstance();
    ApparentPowerLimitBusinessDelegate parentDelegate =
        ApparentPowerLimitBusinessDelegate.getApparentPowerLimitInstance();
    UUID childId = command.getAssignment().getApparentPowerId();
    ApparentPower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ApparentPowerLimitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get ApparentPower using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Value on ApparentPowerLimit
   *
   * @param command UnAssignValueFromApparentPowerLimitCommand
   * @exception ProcessingException
   */
  public void unAssignValue(UnAssignValueFromApparentPowerLimitCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ApparentPowerLimitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Value on ApparentPowerLimit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return ApparentPowerLimit
   */
  private ApparentPowerLimit load(UUID id) throws ProcessingException {
    apparentPowerLimit =
        ApparentPowerLimitBusinessDelegate.getApparentPowerLimitInstance()
            .getApparentPowerLimit(new ApparentPowerLimitFetchOneSummary(id));
    return apparentPowerLimit;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private ApparentPowerLimit apparentPowerLimit = null;
  private static final Logger LOGGER =
      Logger.getLogger(ApparentPowerLimitBusinessDelegate.class.getName());
}
