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
 * TurbineGovernorUserDefined business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of TurbineGovernorUserDefined related services in the case of a
 *       TurbineGovernorUserDefined business related service failing.
 *   <li>Exposes a simpler, uniform TurbineGovernorUserDefined interface to the business tier,
 *       making it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill TurbineGovernorUserDefined
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class TurbineGovernorUserDefinedBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public TurbineGovernorUserDefinedBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * TurbineGovernorUserDefined Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return TurbineGovernorUserDefinedBusinessDelegate
   */
  public static TurbineGovernorUserDefinedBusinessDelegate getTurbineGovernorUserDefinedInstance() {
    return (new TurbineGovernorUserDefinedBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createTurbineGovernorUserDefined(
      CreateTurbineGovernorUserDefinedCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getTurbineGovernorUserDefinedId() == null)
        command.setTurbineGovernorUserDefinedId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      TurbineGovernorUserDefinedValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateTurbineGovernorUserDefinedCommand - by convention the future return value
      // for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateTurbineGovernorUserDefinedCommand of TurbineGovernorUserDefined is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create TurbineGovernorUserDefined - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateTurbineGovernorUserDefinedCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateTurbineGovernorUserDefined(
      UpdateTurbineGovernorUserDefinedCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      TurbineGovernorUserDefinedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateTurbineGovernorUserDefinedCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save TurbineGovernorUserDefined - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteTurbineGovernorUserDefinedCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteTurbineGovernorUserDefinedCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TurbineGovernorUserDefinedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteTurbineGovernorUserDefinedCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete TurbineGovernorUserDefined using Id = "
              + command.getTurbineGovernorUserDefinedId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the TurbineGovernorUserDefined via TurbineGovernorUserDefinedFetchOneSummary
   *
   * @param summary TurbineGovernorUserDefinedFetchOneSummary
   * @return TurbineGovernorUserDefinedFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public TurbineGovernorUserDefined getTurbineGovernorUserDefined(
      TurbineGovernorUserDefinedFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "TurbineGovernorUserDefinedFetchOneSummary arg cannot be null");

    TurbineGovernorUserDefined entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      TurbineGovernorUserDefinedValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a TurbineGovernorUserDefined
      // --------------------------------------
      CompletableFuture<TurbineGovernorUserDefined> futureEntity =
          queryGateway.query(
              new FindTurbineGovernorUserDefinedQuery(
                  new LoadTurbineGovernorUserDefinedFilter(
                      summary.getTurbineGovernorUserDefinedId())),
              ResponseTypes.instanceOf(TurbineGovernorUserDefined.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate TurbineGovernorUserDefined with id "
              + summary.getTurbineGovernorUserDefinedId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all TurbineGovernorUserDefineds
   *
   * @return List<TurbineGovernorUserDefined>
   * @exception ProcessingException Thrown if any problems
   */
  public List<TurbineGovernorUserDefined> getAllTurbineGovernorUserDefined()
      throws ProcessingException {
    List<TurbineGovernorUserDefined> list = null;

    try {
      CompletableFuture<List<TurbineGovernorUserDefined>> futureList =
          queryGateway.query(
              new FindAllTurbineGovernorUserDefinedQuery(),
              ResponseTypes.multipleInstancesOf(TurbineGovernorUserDefined.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all TurbineGovernorUserDefined";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Proprietary on TurbineGovernorUserDefined
   *
   * @param command AssignProprietaryToTurbineGovernorUserDefinedCommand
   * @exception ProcessingException
   */
  public void assignProprietary(AssignProprietaryToTurbineGovernorUserDefinedCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTurbineGovernorUserDefinedId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    TurbineGovernorUserDefinedBusinessDelegate parentDelegate =
        TurbineGovernorUserDefinedBusinessDelegate.getTurbineGovernorUserDefinedInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TurbineGovernorUserDefinedValidator.getInstance().validate(command);

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
   * unAssign Proprietary on TurbineGovernorUserDefined
   *
   * @param command UnAssignProprietaryFromTurbineGovernorUserDefinedCommand
   * @exception ProcessingException
   */
  public void unAssignProprietary(UnAssignProprietaryFromTurbineGovernorUserDefinedCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TurbineGovernorUserDefinedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Proprietary on TurbineGovernorUserDefined";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return TurbineGovernorUserDefined
   */
  private TurbineGovernorUserDefined load(UUID id) throws ProcessingException {
    turbineGovernorUserDefined =
        TurbineGovernorUserDefinedBusinessDelegate.getTurbineGovernorUserDefinedInstance()
            .getTurbineGovernorUserDefined(new TurbineGovernorUserDefinedFetchOneSummary(id));
    return turbineGovernorUserDefined;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private TurbineGovernorUserDefined turbineGovernorUserDefined = null;
  private static final Logger LOGGER =
      Logger.getLogger(TurbineGovernorUserDefinedBusinessDelegate.class.getName());
}
