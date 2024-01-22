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
 * SynchronousMachineUserDefined business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of SynchronousMachineUserDefined related services in the case of a
 *       SynchronousMachineUserDefined business related service failing.
 *   <li>Exposes a simpler, uniform SynchronousMachineUserDefined interface to the business tier,
 *       making it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill
 *       SynchronousMachineUserDefined business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class SynchronousMachineUserDefinedBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public SynchronousMachineUserDefinedBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * SynchronousMachineUserDefined Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return SynchronousMachineUserDefinedBusinessDelegate
   */
  public static SynchronousMachineUserDefinedBusinessDelegate
      getSynchronousMachineUserDefinedInstance() {
    return (new SynchronousMachineUserDefinedBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createSynchronousMachineUserDefined(
      CreateSynchronousMachineUserDefinedCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getSynchronousMachineUserDefinedId() == null)
        command.setSynchronousMachineUserDefinedId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineUserDefinedValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateSynchronousMachineUserDefinedCommand - by convention the future return
      // value for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateSynchronousMachineUserDefinedCommand of SynchronousMachineUserDefined is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create SynchronousMachineUserDefined - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateSynchronousMachineUserDefinedCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateSynchronousMachineUserDefined(
      UpdateSynchronousMachineUserDefinedCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      SynchronousMachineUserDefinedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateSynchronousMachineUserDefinedCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save SynchronousMachineUserDefined - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteSynchronousMachineUserDefinedCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteSynchronousMachineUserDefinedCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineUserDefinedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteSynchronousMachineUserDefinedCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete SynchronousMachineUserDefined using Id = "
              + command.getSynchronousMachineUserDefinedId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the SynchronousMachineUserDefined via
   * SynchronousMachineUserDefinedFetchOneSummary
   *
   * @param summary SynchronousMachineUserDefinedFetchOneSummary
   * @return SynchronousMachineUserDefinedFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public SynchronousMachineUserDefined getSynchronousMachineUserDefined(
      SynchronousMachineUserDefinedFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "SynchronousMachineUserDefinedFetchOneSummary arg cannot be null");

    SynchronousMachineUserDefined entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      SynchronousMachineUserDefinedValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a SynchronousMachineUserDefined
      // --------------------------------------
      CompletableFuture<SynchronousMachineUserDefined> futureEntity =
          queryGateway.query(
              new FindSynchronousMachineUserDefinedQuery(
                  new LoadSynchronousMachineUserDefinedFilter(
                      summary.getSynchronousMachineUserDefinedId())),
              ResponseTypes.instanceOf(SynchronousMachineUserDefined.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate SynchronousMachineUserDefined with id "
              + summary.getSynchronousMachineUserDefinedId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all SynchronousMachineUserDefineds
   *
   * @return List<SynchronousMachineUserDefined>
   * @exception ProcessingException Thrown if any problems
   */
  public List<SynchronousMachineUserDefined> getAllSynchronousMachineUserDefined()
      throws ProcessingException {
    List<SynchronousMachineUserDefined> list = null;

    try {
      CompletableFuture<List<SynchronousMachineUserDefined>> futureList =
          queryGateway.query(
              new FindAllSynchronousMachineUserDefinedQuery(),
              ResponseTypes.multipleInstancesOf(SynchronousMachineUserDefined.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all SynchronousMachineUserDefined";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Proprietary on SynchronousMachineUserDefined
   *
   * @param command AssignProprietaryToSynchronousMachineUserDefinedCommand
   * @exception ProcessingException
   */
  public void assignProprietary(AssignProprietaryToSynchronousMachineUserDefinedCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineUserDefinedId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    SynchronousMachineUserDefinedBusinessDelegate parentDelegate =
        SynchronousMachineUserDefinedBusinessDelegate.getSynchronousMachineUserDefinedInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineUserDefinedValidator.getInstance().validate(command);

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
   * unAssign Proprietary on SynchronousMachineUserDefined
   *
   * @param command UnAssignProprietaryFromSynchronousMachineUserDefinedCommand
   * @exception ProcessingException
   */
  public void unAssignProprietary(
      UnAssignProprietaryFromSynchronousMachineUserDefinedCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineUserDefinedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Proprietary on SynchronousMachineUserDefined";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return SynchronousMachineUserDefined
   */
  private SynchronousMachineUserDefined load(UUID id) throws ProcessingException {
    synchronousMachineUserDefined =
        SynchronousMachineUserDefinedBusinessDelegate.getSynchronousMachineUserDefinedInstance()
            .getSynchronousMachineUserDefined(new SynchronousMachineUserDefinedFetchOneSummary(id));
    return synchronousMachineUserDefined;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private SynchronousMachineUserDefined synchronousMachineUserDefined = null;
  private static final Logger LOGGER =
      Logger.getLogger(SynchronousMachineUserDefinedBusinessDelegate.class.getName());
}
