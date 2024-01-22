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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.validator.*;
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
 * UnderexcitationLimiterUserDefined business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of UnderexcitationLimiterUserDefined related services in the case
 *       of a UnderexcitationLimiterUserDefined business related service failing.
 *   <li>Exposes a simpler, uniform UnderexcitationLimiterUserDefined interface to the business
 *       tier, making it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill
 *       UnderexcitationLimiterUserDefined business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class UnderexcitationLimiterUserDefinedBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public UnderexcitationLimiterUserDefinedBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * UnderexcitationLimiterUserDefined Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return UnderexcitationLimiterUserDefinedBusinessDelegate
   */
  public static UnderexcitationLimiterUserDefinedBusinessDelegate
      getUnderexcitationLimiterUserDefinedInstance() {
    return (new UnderexcitationLimiterUserDefinedBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createUnderexcitationLimiterUserDefined(
      CreateUnderexcitationLimiterUserDefinedCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getUnderexcitationLimiterUserDefinedId() == null)
        command.setUnderexcitationLimiterUserDefinedId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcitationLimiterUserDefinedValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateUnderexcitationLimiterUserDefinedCommand - by convention the future return
      // value for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateUnderexcitationLimiterUserDefinedCommand of UnderexcitationLimiterUserDefined is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create UnderexcitationLimiterUserDefined - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateUnderexcitationLimiterUserDefinedCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateUnderexcitationLimiterUserDefined(
      UpdateUnderexcitationLimiterUserDefinedCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      UnderexcitationLimiterUserDefinedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateUnderexcitationLimiterUserDefinedCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save UnderexcitationLimiterUserDefined - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteUnderexcitationLimiterUserDefinedCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteUnderexcitationLimiterUserDefinedCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcitationLimiterUserDefinedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteUnderexcitationLimiterUserDefinedCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete UnderexcitationLimiterUserDefined using Id = "
              + command.getUnderexcitationLimiterUserDefinedId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the UnderexcitationLimiterUserDefined via
   * UnderexcitationLimiterUserDefinedFetchOneSummary
   *
   * @param summary UnderexcitationLimiterUserDefinedFetchOneSummary
   * @return UnderexcitationLimiterUserDefinedFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public UnderexcitationLimiterUserDefined getUnderexcitationLimiterUserDefined(
      UnderexcitationLimiterUserDefinedFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "UnderexcitationLimiterUserDefinedFetchOneSummary arg cannot be null");

    UnderexcitationLimiterUserDefined entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      UnderexcitationLimiterUserDefinedValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a UnderexcitationLimiterUserDefined
      // --------------------------------------
      CompletableFuture<UnderexcitationLimiterUserDefined> futureEntity =
          queryGateway.query(
              new FindUnderexcitationLimiterUserDefinedQuery(
                  new LoadUnderexcitationLimiterUserDefinedFilter(
                      summary.getUnderexcitationLimiterUserDefinedId())),
              ResponseTypes.instanceOf(UnderexcitationLimiterUserDefined.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate UnderexcitationLimiterUserDefined with id "
              + summary.getUnderexcitationLimiterUserDefinedId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all UnderexcitationLimiterUserDefineds
   *
   * @return List<UnderexcitationLimiterUserDefined>
   * @exception ProcessingException Thrown if any problems
   */
  public List<UnderexcitationLimiterUserDefined> getAllUnderexcitationLimiterUserDefined()
      throws ProcessingException {
    List<UnderexcitationLimiterUserDefined> list = null;

    try {
      CompletableFuture<List<UnderexcitationLimiterUserDefined>> futureList =
          queryGateway.query(
              new FindAllUnderexcitationLimiterUserDefinedQuery(),
              ResponseTypes.multipleInstancesOf(UnderexcitationLimiterUserDefined.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all UnderexcitationLimiterUserDefined";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Proprietary on UnderexcitationLimiterUserDefined
   *
   * @param command AssignProprietaryToUnderexcitationLimiterUserDefinedCommand
   * @exception ProcessingException
   */
  public void assignProprietary(AssignProprietaryToUnderexcitationLimiterUserDefinedCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcitationLimiterUserDefinedId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    UnderexcitationLimiterUserDefinedBusinessDelegate parentDelegate =
        UnderexcitationLimiterUserDefinedBusinessDelegate
            .getUnderexcitationLimiterUserDefinedInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcitationLimiterUserDefinedValidator.getInstance().validate(command);

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
   * unAssign Proprietary on UnderexcitationLimiterUserDefined
   *
   * @param command UnAssignProprietaryFromUnderexcitationLimiterUserDefinedCommand
   * @exception ProcessingException
   */
  public void unAssignProprietary(
      UnAssignProprietaryFromUnderexcitationLimiterUserDefinedCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcitationLimiterUserDefinedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Proprietary on UnderexcitationLimiterUserDefined";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return UnderexcitationLimiterUserDefined
   */
  private UnderexcitationLimiterUserDefined load(UUID id) throws ProcessingException {
    underexcitationLimiterUserDefined =
        UnderexcitationLimiterUserDefinedBusinessDelegate
            .getUnderexcitationLimiterUserDefinedInstance()
            .getUnderexcitationLimiterUserDefined(
                new UnderexcitationLimiterUserDefinedFetchOneSummary(id));
    return underexcitationLimiterUserDefined;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private UnderexcitationLimiterUserDefined underexcitationLimiterUserDefined = null;
  private static final Logger LOGGER =
      Logger.getLogger(UnderexcitationLimiterUserDefinedBusinessDelegate.class.getName());
}
